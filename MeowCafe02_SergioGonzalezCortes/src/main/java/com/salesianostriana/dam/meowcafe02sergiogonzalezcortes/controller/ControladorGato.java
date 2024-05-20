package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.controller;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.exception.VacunaSinGato;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Vacuna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Gato;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioGato;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Controller
public class ControladorGato {

	
	@Autowired
	private ServicioGato servicioGato;



	@GetMapping("/admin/gatos")
	public String mostrarGatitosAdmin(Model model) {

		model.addAttribute("gatitos", servicioGato.findAll());

		return "admin/gatitos";
	}

	@GetMapping("/admin/formularioGatos")
	public String formularioGatinios(Model model) {

		Gato gato = new Gato();

		model.addAttribute("gato", gato);

		return "admin/formularioGatitos";
	}

	
	@GetMapping("/gatos")
	public String mostrarGatitos(Model model) {
		
		model.addAttribute("gatitos", servicioGato.gatosDisponibles());
		
		return "gatitos";
	}


	@GetMapping("/cliente/gatos")
	public String mostrarGatitosAClientes(Model model) {

		model.addAttribute("gatitos", servicioGato.gatosDisponibles());

		return "cliente/gatitos";
	}


	@PostMapping("/admin/formularioGatos/agregar")
	public String agregarGatinio (@ModelAttribute("gato") Gato gato) {

		servicioGato.save(gato);


		return "redirect:/admin/gatos";
	}


	@GetMapping("/admin/formularioGatos/{id}")
	public String formularioEditar(@PathVariable("id") long id, Model model) {

		if (servicioGato.findById(id).isPresent()) {
			model.addAttribute("gato", servicioGato.findById(id).get());

			return "/admin/formularioGatitos";
		}

		else {

			return "redirect:/admin/gatos";
		}

	}

	@PostMapping("/admin/formularioGatos/editar")
	public String editarGatinio(@ModelAttribute("gato") Gato gato) {

		servicioGato.edit(gato);

		return "redirect:/admin/gatos";
	}

	@GetMapping("/admin/vacunas/{id}")
	public String formularioVacunas(@PathVariable(value = "id", required = false) long id, Model model) throws VacunaSinGato, NoResourceFoundException {

		if (servicioGato.findById(id).isPresent()) {

			model.addAttribute("gato", servicioGato.findById(id).get());
			model.addAttribute("vacuna", new Vacuna());

			return "admin/formularioVacuna";
		}
		else {

			throw new VacunaSinGato();
		}
	}

	@PostMapping("/admin/vacunas/ponerVacuna")
	public String ponerVacuna (@ModelAttribute("gato") Gato gato, @ModelAttribute("vacuna") Vacuna vacuna) {

		gato.addVacuna(vacuna);
		servicioGato.cambiarDisponibilidad(gato);

		servicioGato.edit(gato);

		return "redirect:/admin/gatos";
	}

	@GetMapping("/admin/borrarGato/{id}")
	public String borrarGato(@PathVariable("id") long id) {

		if (servicioGato.findById(id).isPresent()) {

			servicioGato.deleteById(id);
		}

		return "redirect:/admin/gatos";
	}
}
