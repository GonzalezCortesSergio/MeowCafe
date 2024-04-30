package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioGato;

@Controller
public class ControladorGato {

	
	@Autowired
	private ServicioGato servicioGato;
	
	@GetMapping("/gatos")
	public String mostrarGatitos(Model model) {
		
		model.addAttribute("gatitos", servicioGato.findAll());
		
		return "gatitos";
	}
}
