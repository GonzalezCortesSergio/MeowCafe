package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaReserva {

    @Id
    @GeneratedValue
    private Long id;

    private List<Gato> gatosReservados;

    private LocalTime horasReservadas;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_linea_reserva_combo"))
    private Combo combo;

    private double subTotal;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_linea_reserva_reserva"))
    private Reserva reserva;

    //HELPER

    public void addToCombo(Combo combo) {

        this.combo = combo;
        combo.getLineasReserva().add(this);
    }

    public void removeFromCombo(Combo combo) {

        combo.getLineasReserva().remove(this);

        this.combo = null;
    }
}
