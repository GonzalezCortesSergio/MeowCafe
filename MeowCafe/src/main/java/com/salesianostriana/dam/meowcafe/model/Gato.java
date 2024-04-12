package com.salesianostriana.dam.meowcafe.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Gato {

	private String nombre;
	private int id;
	private LocalDateTime horasDisponible;
	private boolean ocupado;
	private boolean vacunado;
}
