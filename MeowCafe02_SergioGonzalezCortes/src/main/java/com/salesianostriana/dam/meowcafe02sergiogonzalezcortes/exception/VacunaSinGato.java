package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.exception;

import jakarta.servlet.ServletException;

public class VacunaSinGato extends ServletException {

    public VacunaSinGato() {

        super("Estás intentando insertar una vacuna a un gato que todavía no está registrado");
    }
}
