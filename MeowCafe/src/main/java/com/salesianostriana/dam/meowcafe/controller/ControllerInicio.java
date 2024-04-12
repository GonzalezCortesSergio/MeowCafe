package com.salesianostriana.dam.meowcafe.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.meowcafe.model.Gato;

@Controller
public class ControllerInicio {

	@GetMapping("/gatitos")
	public String mostrarGatitos (Model model) {
		
		model.addAttribute("gatito", new Gato("Puspus", 1, LocalDateTime.now(), false, true));
		
		return "gatitos";
	}
}
