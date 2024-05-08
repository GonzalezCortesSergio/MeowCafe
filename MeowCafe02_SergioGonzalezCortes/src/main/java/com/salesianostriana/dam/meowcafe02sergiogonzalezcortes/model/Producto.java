package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private double precio;
	
	@Enumerated(EnumType.STRING)
	private TipoProducto tipoProducto;
	
	@ManyToOne
	private Combo combo;

}
