package com.app.estacionamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.estacionamiento.entities.Auto;
import com.app.estacionamiento.service.AutoService;

@Controller
public class AutoController {
	
	@Autowired
	AutoService autoService;
	
	//MÉTODO PARA LISTAR TODOS LOS AUTOS
	@GetMapping("/listar")
	public String listarAutos(Model model) {
	    List<Auto> autos = autoService.findAllOrderedByMatricula();
	    model.addAttribute("titulo", "Estacionamiento las Olas");
	    model.addAttribute("autos", autos); 
	    return "/inicio/inicio";
	}
	
	//MÉTODO PARA GUARDAR (INGRESAR UN NUEVO REGISTRO) UN AUTO
    @PostMapping("/autos/guardar")
    @ResponseBody
    public ResponseEntity<String> guardarAuto(@RequestBody Auto auto) {
        try {
            autoService.save(auto);
            return ResponseEntity.ok("Auto guardado con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar el auto: " + e.getMessage());
        }
    }
    
    //OBTENER LOS DATOS DE UN AUTO
    @GetMapping("/autos/{matricula}")
    public ResponseEntity<Auto> obtenerAutoPorMatricula(@PathVariable String matricula) {
        Auto auto = autoService.obtenerAutoPorMatricula(matricula);
        if (auto != null) {
            return ResponseEntity.ok(auto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/autos/editar")
    public ResponseEntity<Auto> actualizarAuto(@RequestBody Auto auto) {
        Auto autoActualizado = autoService.actualizarAuto(auto);
        if (autoActualizado != null) {
            return ResponseEntity.ok(autoActualizado);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

