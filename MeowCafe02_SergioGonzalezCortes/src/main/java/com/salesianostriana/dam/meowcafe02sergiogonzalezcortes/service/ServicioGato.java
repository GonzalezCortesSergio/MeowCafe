package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Vacuna;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Gato;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.repository.RepositorioGato;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.base.ServicioBaseImpl;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioGato extends ServicioBaseImpl<Gato, Long, RepositorioGato>{


    public List<Gato> gatosDisponibles() {

        return repository.gatosDisponibles();
    }



    public void cambiarDisponibilidad(Gato g) {

        if (!g.getVacunas().isEmpty()) {
            LocalDate fechaActual = LocalDate.now();

            LocalDate fechaUltimaVacuna = g.getVacunas().get(g.getVacunas().size() - 1).getFechaVacuna();

            g.setVacunado(fechaUltimaVacuna != null && fechaUltimaVacuna.isAfter(fechaActual.minusYears(1)));
        }


    }

}
