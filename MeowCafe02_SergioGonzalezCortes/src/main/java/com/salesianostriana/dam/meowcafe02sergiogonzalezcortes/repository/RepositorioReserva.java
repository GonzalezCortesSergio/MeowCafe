package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.repository;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioReserva extends JpaRepository<Reserva, Long> {

    @Query("""
            SELECT r
            FROM Reserva r
            WHERE r.terminada IS TRUE
            """)
    List<Reserva> reservasFinalizadas();
}
