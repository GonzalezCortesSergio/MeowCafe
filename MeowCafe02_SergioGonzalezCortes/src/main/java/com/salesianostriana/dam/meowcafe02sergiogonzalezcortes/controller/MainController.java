package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"/", "/index"})
    public String index() {

        return "index";
    }

    @GetMapping("/sobreNosotros")
    public String sobreNosotros() {

        return "sobreNosotros";
    }
}
