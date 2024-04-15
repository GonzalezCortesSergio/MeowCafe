package com.salesianostriana.dam.meowcafe;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.meowcafe.model.Gato;

@Controller
public class ControladorGatitos {

	
	@GetMapping("/gatitos")
	public String imprimirGatitos(Model model) {
		
		model.addAttribute("gatito", new Gato("Minimiau", 1, LocalDateTime.now(), false, true, "https://images.hola.com/imagenes/mascotas/20180925130054/consejos-para-cuidar-a-un-gatito-recien-nacido-cs/0-601-526/cuidardgatito-t.jpg"));
		
		return "gatitos";
	}
	
	
}
