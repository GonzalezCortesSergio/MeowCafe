package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioUsuario;

@Controller
public class ControladorUsuario {

	@Autowired
	private ServicioUsuario servicioUsuario;
	
	
	@GetMapping("/clientes")
	public String mostrarClientesRegistrados(Model model) {
		
		model.addAttribute("clientes", servicioUsuario.findAll().stream()
				.filter(usuario -> usuario.getTipo().toString().equals("CLIENTE"))
				.toList());
		
		
		return "clientes";
	}
}
