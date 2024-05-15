package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.controller;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.TipoUsuario;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	@Autowired
	private PasswordEncoder passwordEncoder;


	@GetMapping("/formularioRegistro")
	public String formularioRegistroUsuario (Model model) {

		model.addAttribute("usuario", Usuario.builder()
				.tipo(TipoUsuario.CLIENTE)
				.build());


		return "formularioRegistro";
	}


	@PostMapping("/formularioRegistro/registro")
	public String registroUsuario(@ModelAttribute("usuario") Usuario usuario) {

		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

		servicioUsuario.save(usuario);
		return "redirect:/";
	}

}
