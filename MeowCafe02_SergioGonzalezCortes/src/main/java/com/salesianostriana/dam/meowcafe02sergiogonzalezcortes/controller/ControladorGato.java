package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
		
		model.addAttribute("gato", gato);
		
		return "formularioGatitos";
	}
	
	@PostMapping("/formularioGatos/agregar")
	public String agregarGatinio (@ModelAttribute("gato") Gato gato) {
		
		servicioGato.save(gato);
		
		
		return "redirect:/gatos";
	}
	
	@GetMapping("/formularioGatos/{id}")
	public String formularioEditar(@PathVariable("id") long id, Model model) {
		
		model.addAttribute("gato", servicioGato.findById(id).get());
		
		return "formularioGatitos";
	}
	
	@PostMapping("/formularioGatos/editar")
	public String editarGatinio(@ModelAttribute("gato") Gato gato) {
		
		servicioGato.edit(gato);
		
		return "redirect:/gatos";
	}

	@GetMapping("/borrarGato/{id}")
	@ResponseBody
	public void borrarGato(@PathVariable("id") long id) {

	}

	@GetMapping("/borrarGato/confirmarBorrado/{id}")
	public String confirmarBorrado(@PathVariable("id") long id) {

		servicioGato.deleteById(id);

		return "redirect:/gatos";
	}
}
