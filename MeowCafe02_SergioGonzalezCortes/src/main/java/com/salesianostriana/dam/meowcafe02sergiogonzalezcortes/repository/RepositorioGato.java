package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Gato;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioGato extends JpaRepository<Gato, Long>{

    @Query("""
            SELECT g
            FROM Gato g
            WHERE g.vacunado IS TRUE
            """)
    public List<Gato> gatosDisponibles ();
}
