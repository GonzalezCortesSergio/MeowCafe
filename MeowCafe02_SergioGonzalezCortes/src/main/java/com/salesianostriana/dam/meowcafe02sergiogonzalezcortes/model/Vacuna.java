package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vacuna {

    @Id
    @GeneratedValue
    private Long id;

    private String nombreVacuna;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaVacuna;


    @ManyToOne
    private Gato gato;

}
