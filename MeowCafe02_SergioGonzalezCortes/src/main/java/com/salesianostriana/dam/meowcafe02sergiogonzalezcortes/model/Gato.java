package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

	//private List<Vacuna> listaVacunas;

}
