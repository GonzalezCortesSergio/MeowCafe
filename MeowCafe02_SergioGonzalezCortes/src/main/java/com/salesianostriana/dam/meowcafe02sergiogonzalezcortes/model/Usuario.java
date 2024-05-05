package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SequenceGenerator(name = "secuenciaUsuario", sequenceName = "usuario_seq", initialValue = 3)
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuenciaUsuario")
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
