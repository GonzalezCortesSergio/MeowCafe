package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@Controller
public class ControladorAccesoDenegado {

    @ExceptionHandler(AccessDeniedException.class)
    public String accesoDenegado() {

        return "accesoDenegado";
    }
}
