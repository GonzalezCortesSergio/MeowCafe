package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.repository;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Reserva;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositorioReserva extends JpaRepository<Reserva, Long> {

    @Query("""
            SELECT r
            FROM Reserva r
            WHERE r.terminada IS TRUE
            """)
    List<Reserva> reservasFinalizadas();

    @Query("""
            SELECT r
            FROM Reserva r
            WHERE r.usuarioReserva = :usuario AND r.terminada IS TRUE
            """)
    List<Reserva> reservasFinalizadasUsuario(@Param("usuario") Usuario usuario);
}
