package com.salesianostriana.dam.meowcafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.meowcafe.service.ServicioGato;

@Controller
public class ControladorGato {

	@Autowired
	ServicioGato servicio;
	
	
	@GetMapping("/gatitos")
	public String listarGatos (Model model) {
		
		model.addAttribute("listaGatos", servicio.getLista());
		
		return "gatitos";
	}
}
