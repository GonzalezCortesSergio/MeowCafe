package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	private String apellidos;
	private String email;
	private String username;
	private String password;

	@Enumerated(value = EnumType.STRING)
	private TipoUsuario tipo;
	private boolean esPremium;

}
