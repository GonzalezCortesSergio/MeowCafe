package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaReserva {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_linea_reserva_producto"))
    private Producto producto;

    private int cantidad;


    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_linea_reserva_reserva"))
    private Reserva reserva;

    private double subTotal;


    public void addToReserva(Reserva r) {

        this.reserva = r;
        r.getLineasReserva().add(this);
    }

    public void deleteFromReserva(Reserva r) {

        r.getLineasReserva().remove(this);
        this.reserva = null;
    }
}
