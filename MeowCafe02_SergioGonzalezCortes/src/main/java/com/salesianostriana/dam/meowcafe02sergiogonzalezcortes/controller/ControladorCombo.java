package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.controller;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioCombo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorCombo {

    @Autowired
    private ServicioCombo servicioCombo;

    @GetMapping("/cliente/combos")
    public String mostrarCombos(Model model) {

        model.addAttribute("combos", servicioCombo.findAll());

        return "cliente/combos";
    }
}
