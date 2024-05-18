package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class ControladorAccesoDenegado {

    @ExceptionHandler(AccessDeniedException.class)
    public String accesoDenegado() {

        return "accesoDenegado";
    }
}
