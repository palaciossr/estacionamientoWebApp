package com.app.estacionamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.estacionamiento.entities.Auto;
import com.app.estacionamiento.service.AutoService;

@Controller
public class AutoController {
	
	@Autowired
	AutoService autoService;
	
	@GetMapping("/listar")
	public String listarAutos(Model model) {
	    List<Auto> autos = autoService.findAllOrderedByMatricula();
	    model.addAttribute("titulo", "Estacionamiento las Olas");
	    model.addAttribute("autos", autos); 
	    return "/inicio/inicio";
	}
	
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
}
