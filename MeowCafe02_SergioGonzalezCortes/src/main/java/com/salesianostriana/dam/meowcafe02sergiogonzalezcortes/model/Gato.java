package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

import java.time.LocalTime;

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
@SequenceGenerator(name = "secuenciaGato", sequenceName="gato_seq", initialValue=11)
public class Gato {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="secuenciaGato")
	private Long id;
	
	private String nombre;
	private LocalTime horasDisponibles;
	private boolean ocupado;
}
