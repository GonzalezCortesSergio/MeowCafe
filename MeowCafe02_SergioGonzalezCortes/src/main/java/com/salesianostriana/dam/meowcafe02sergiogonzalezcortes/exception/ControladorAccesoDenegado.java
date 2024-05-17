package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.nio.file.AccessDeniedException;

@ControllerAdvice(assignableTypes = AccessDeniedException.class)
public class ControladorAccesoDenegado {
}
