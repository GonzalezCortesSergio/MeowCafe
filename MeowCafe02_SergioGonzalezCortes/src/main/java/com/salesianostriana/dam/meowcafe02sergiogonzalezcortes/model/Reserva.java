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







    //HELPER


}
