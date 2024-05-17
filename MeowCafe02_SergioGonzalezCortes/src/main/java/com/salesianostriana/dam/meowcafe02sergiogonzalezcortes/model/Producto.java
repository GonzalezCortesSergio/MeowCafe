package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class Producto {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private double precio;
	
	@Enumerated(EnumType.STRING)
	private TipoProducto tipoProducto;

	private String imagen;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@ManyToMany(mappedBy = "producto",fetch = FetchType.EAGER)

	private List<Combo> combo = new ArrayList<Combo>();


	@OneToMany(
			mappedBy = "producto",
			fetch = FetchType.EAGER
	)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	private List<LineaReserva> lineasReserva = new ArrayList<>();


	public void addToCombo(Combo combo) {

		this.combo.add(combo);
		combo.getProducto().add(this);
	}


	public void removeFromCombo(Combo combo) {

		this.combo.remove(combo);
		combo.getProducto().remove(this);


	}


	public void addToLineaReserva(LineaReserva lr) {

		this.lineasReserva.add(lr);

		lr.setProducto(this);
	}

	public void removeFromLineaReserva(LineaReserva lr) {

		lr.setProducto(null);
		this.lineasReserva.remove(lr);
	}


}
