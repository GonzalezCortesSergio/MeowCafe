package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Reserva;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.repository.RepositorioReserva;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.base.ServicioBaseImpl;
import org.springframework.stereotype.Service;

@Service
public class ServicioReserva extends ServicioBaseImpl<Reserva, Long, RepositorioReserva> {
}
