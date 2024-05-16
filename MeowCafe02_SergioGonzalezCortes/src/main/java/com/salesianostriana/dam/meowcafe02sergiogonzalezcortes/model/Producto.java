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
	private double precio;
	
	@Enumerated(EnumType.STRING)
	private TipoProducto tipoProducto;

	private String imagen;
	
	@ManyToMany(mappedBy = "producto", fetch = FetchType.EAGER)
	@Builder.Default
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Combo> combo = new ArrayList<Combo>();


	public void addToCombo(Combo c) {

		this.getCombo().add(c);
		c.getProducto().add(this);
	}

	public void removeFromCombo(Combo c) {

		this.getCombo().remove(c);
		c.getProducto().remove(this);
	}

}
