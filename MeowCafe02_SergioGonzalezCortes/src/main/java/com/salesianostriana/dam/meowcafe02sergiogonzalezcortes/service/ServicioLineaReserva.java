package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.LineaReserva;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.repository.RepositorioLineaReserva;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.base.ServicioBaseImpl;
import org.springframework.stereotype.Service;

@Service
public class ServicioLineaReserva extends ServicioBaseImpl<LineaReserva, Long, RepositorioLineaReserva> {


    public double calcularSubTotal(LineaReserva lineaReserva) {

        return (lineaReserva.getProducto().getPrecio() * lineaReserva.getCantidad());
    }
}
