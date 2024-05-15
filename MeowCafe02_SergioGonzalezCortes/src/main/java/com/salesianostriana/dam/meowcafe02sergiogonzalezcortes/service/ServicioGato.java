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

    public void addVacuna(Vacuna v, Gato g) {

        v.setGato(g);
        g.getVacunas().add(v);

        cambiarDisponibilidad(g);
    }

    private void cambiarDisponibilidad(Gato g) {

        LocalDate fechaActual = LocalDate.now();

        LocalDate fechaUltimaVacuna = g.getVacunas().get(g.getVacunas().size() - 1).getFechaVacuna();

        if (fechaUltimaVacuna.isBefore(fechaActual.minusYears(1))) {

            g.setOcupado(true);
        }

        else {

            g.setOcupado(false);
        }


    }

}
