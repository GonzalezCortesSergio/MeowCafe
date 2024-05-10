package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vacuna {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaVacuna;


    @ManyToOne
    private Gato gato;



    public void addToGato(Gato gato) {

        this.gato = gato;
        gato.getVacunas().add(this);
    }

    public void removeFromGato(Gato gato) {

        gato.getVacunas().remove(this);
        this.gato = null;
    }
}
