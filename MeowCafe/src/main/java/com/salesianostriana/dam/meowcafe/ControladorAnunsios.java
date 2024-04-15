package com.salesianostriana.dam.meowcafe;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorAnunsios {

	@Autowired
	private Anunsios anunsios;
	
	private String anuncioAleatorio () {
		
		Random r = new Random(System.nanoTime());
		
		
		return anunsios.getListaAnuncios().get(r.nextInt(anunsios.getListaAnuncios().size()));
	}
	
	@GetMapping("/index.html")
	public String devolverAnuncio (Model model) {
		
		model.addAttribute("imagen", anuncioAleatorio());
		
		return "index";
	}
}
