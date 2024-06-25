package com.app.estacionamiento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.estacionamiento.service.AutoService;

@Controller
@RequestMapping("/inicio")
public class AutoController {
	
	@Autowired
	AutoService autoService;
	
	@GetMapping("/listar")
	public String listarAutos(Model model) {
		model.addAttribute("titulo","Estacionamiento las Olas");
		return "/inicio/inicio";
		
	}
}
