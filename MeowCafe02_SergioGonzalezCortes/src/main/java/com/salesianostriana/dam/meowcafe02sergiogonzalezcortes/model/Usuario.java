package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	private String apellidos;
	private String email;
	private String nombreUsuario;
	private String contrasena;	

	@Enumerated(value = EnumType.STRING)
	private TipoUsuario tipo;
	private boolean esPremium;
	
	
}
