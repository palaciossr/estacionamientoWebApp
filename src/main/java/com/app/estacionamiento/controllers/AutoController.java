package com.app.estacionamiento.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicio")
public class AutoController {
	
	@GetMapping("/listar")
	public String listarAutos(Model model) {
		model.addAttribute("titulo","Estracionamiento las Olas");
		return "/inicio/listar";
		
	}
}
