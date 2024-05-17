package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gato {

	@Id
	@GeneratedValue
	private Long id;

	private String nombre;
	private LocalTime horasDisponibles;
	private boolean ocupado;
	private String imagen;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "gato",
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	@Builder.Default
	private List<Vacuna> vacunas = new ArrayList<>();


	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@ManyToMany(mappedBy = "gatosReservados")
	private List<Reserva> reservas = new ArrayList<>();


	public void addVacuna(Vacuna v) {

		v.setGato(this);
		this.vacunas.add(v);

	}


	public void addToReserva(Reserva r) {

		this.reservas.add(r);
		r.getGatosReservados().add(this);
	}

	public void removeFromReserva(Reserva r) {

		r.getGatosReservados().remove(this);
		this.reservas.remove(r);
	}
}
