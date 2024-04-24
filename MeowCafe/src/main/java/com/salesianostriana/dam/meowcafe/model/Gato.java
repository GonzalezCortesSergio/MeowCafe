package com.salesianostriana.dam.meowcafe.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gato {

	private int id;
	private String nombre;
	private LocalDateTime horasDisponible;
	private boolean ocupado;
	private boolean vacunado;
	private String imagen;
}
