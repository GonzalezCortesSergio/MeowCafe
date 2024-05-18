package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime fechaReserva;

    private double horasReservadas;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "reserva",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<LineaReserva> lineasReserva = new ArrayList<>();



    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (
            name = "reserva_gato",
            joinColumns = @JoinColumn(name = "reserva_id"),
            inverseJoinColumns = @JoinColumn(name = "gato_id")
    )
    private List<Gato> gatosReservados = new ArrayList<>();



    //HELPER

    public void addLineaReserva(LineaReserva lr) {

        lr.setReserva(this);
        this.lineasReserva.add(lr);
    }

    public void removeLineaReserva(LineaReserva lr) {

        this.lineasReserva.remove(lr);
        lr.setReserva(null);
    }

}
