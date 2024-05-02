package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Gato;
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
	
	@GetMapping("/formularioGatos")
	public String formularioGatinios(Model model) {
		
		Gato gato = new Gato();
		
		model.addAttribute("gatoNuevo", gato);
		
		return "formularioGatitos";
	}
	
	@PostMapping("/agregarGato")
	public String agregarGatinio (@ModelAttribute("gatoNuevo") Gato gato ,Model model) {
		
		servicioGato.save(gato);
		
		model.addAttribute("gatitos", servicioGato.findAll());
		
		return "gatitos";
	}
}
