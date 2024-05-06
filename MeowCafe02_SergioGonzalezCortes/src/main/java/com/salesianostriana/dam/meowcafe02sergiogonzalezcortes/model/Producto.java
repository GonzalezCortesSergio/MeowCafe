package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
	private float precio;
	
	@Enumerated(EnumType.STRING)
	private TipoProducto tipoProducto;
	
	@ManyToMany(mappedBy = "productos", fetch = FetchType.EAGER)
	@Builder.Default
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Combo> combos = new ArrayList<Combo>();

}
