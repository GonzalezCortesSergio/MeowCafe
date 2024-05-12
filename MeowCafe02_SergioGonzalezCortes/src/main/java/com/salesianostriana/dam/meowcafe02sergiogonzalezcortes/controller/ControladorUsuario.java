package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.controller;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.TipoUsuario;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioUsuario;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorUsuario {

	@Autowired
	private ServicioUsuario servicioUsuario;


	@GetMapping("/formularioRegistro")
	public String formularioRegistroUsuario (Model model) {

		model.addAttribute("usuario", new Usuario());


		return "formularioRegistro";
	}


	@PostMapping("/formularioRegistro/registro")
	public String registroUsuario(@ModelAttribute("usuario") Usuario usuario) {

		usuario.setTipo(TipoUsuario.CLIENTE);

		servicioUsuario.save(usuario);
		return "redirect:/";
	}

}
