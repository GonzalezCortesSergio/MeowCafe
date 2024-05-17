package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Combo extends Producto{

	
	private boolean esOferta;

	private List<String> imagenCombo;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable (
			name = "producto_combo",
			joinColumns = @JoinColumn(name = "combo_id"),
			inverseJoinColumns = @JoinColumn(name = "producto_id")
	)
	private List<Producto> producto = new ArrayList<Producto>();





} 
