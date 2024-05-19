package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.LineaReserva;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Reserva;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Usuario;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.repository.RepositorioReserva;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.base.ServicioBaseImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioReserva extends ServicioBaseImpl<Reserva, Long, RepositorioReserva> {

    private double calcularPrecioTotal (Reserva reserva) {

        double precioProductos = reserva.getLineasReserva().stream() //Se suma el precio de todos los productos
                .mapToDouble(LineaReserva::getSubTotal)
                .sum();

        double precioHoras = reserva.getHorasReservadas() * 3; //Cada media hora vale 3€

        /*
            Se aplica el precio de las horas a un adicional en función del número de gatos reservados
        */
        if(!reserva.getGatosReservados().isEmpty())
            precioHoras*= (reserva.getGatosReservados().size() + 0.25);

        return precioProductos + precioHoras;


    }

    public Reserva getReserva(Usuario usuario) {

        if(!usuario.getReservas().isEmpty()) {
            if (!usuario.getReservas().get(usuario.getReservas().size() - 1).isTerminada()) {

                return usuario.getReservas().get(usuario.getReservas().size() - 1);
            }

        }

        Reserva reserva = new Reserva();
        reserva.addToUsuario(usuario);

        return reserva;
    }

    public void terminarReserva(Reserva reserva) {

        reserva.setTerminada(true);

        reserva.setPrecioFinal(calcularPrecioTotal(reserva));
    }

    public List<Reserva> reservasTerminadas() {

        return repository.reservasFinalizadas();
    }
}
