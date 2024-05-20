package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class ControladorAccesoDenegado {

    @ExceptionHandler(value = AccessDeniedException.class)
    public String accesoDenegado() {

        return "accesoDenegado";
    }

    @ExceptionHandler(value = VacunaSinGato.class)
    public String avisoVacunaSinGato(VacunaSinGato err, Model model) {

        model.addAttribute(model.addAttribute("error", err.getMessage()));

        return "admin/vacunaSinGato";
    }
}
