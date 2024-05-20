package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Gato;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.LineaReserva;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Reserva;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Usuario;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.repository.RepositorioReserva;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.base.ServicioBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ServicioReserva extends ServicioBaseImpl<Reserva, Long, RepositorioReserva> {

    @Autowired
    private ServicioUsuario servicioUsuario;


    private double calcularPrecioTotal (Reserva reserva) {

        int numReservasDescuento = 2;
        double descuentoNormal = 0.05;
        double descuentoPremium = 0.25;
        double valorHora = 3;
        double porcentajeAdicional = 0.25;

        double precioProductos = reserva.getLineasReserva().stream() //Se suma el precio de todos los productos
                .mapToDouble(LineaReserva::getSubTotal)
                .sum();

        double precioHoras = reserva.getHorasReservadas() * valorHora; //Cada media hora vale 3€

        /*
            Se aplica el precio de las horas a un adicional en función del número de gatos reservados
        */
        if(!reserva.getGatosReservados().isEmpty()) {

            int largo = reserva.getGatosReservados().stream()
                    .filter(Objects::nonNull)
                    .toList().size();

            if (largo > 0) {
                precioHoras += (largo * porcentajeAdicional);
            }
        }


        if(reserva.getUsuarioReserva().getReservas().size() % numReservasDescuento == 0) {

            if(reserva.getUsuarioReserva().isEsPremium())
                return (precioProductos + precioHoras) - (1 * descuentoPremium);


            return (precioProductos + precioHoras) - (1 * descuentoNormal);
        }

        return precioProductos + precioHoras;


    }

    public Reserva getReserva(Usuario usuario) {

        Usuario usuarioRegistrado = servicioUsuario.findById(usuario.getId()).get();
        if(!usuario.getReservas().isEmpty()) {

            Optional<Reserva> reservaOptional = usuarioRegistrado.getReservas().stream()
                    .filter(reserva -> !reserva.isTerminada())
                    .findAny();

            return reservaOptional.orElseGet(Reserva::new);

        }



        return new Reserva();
    }

    public void terminarReserva(Reserva reserva) {

        reserva.setTerminada(true);

        reserva.setPrecioFinal(calcularPrecioTotal(reserva));
    }

    public List<Reserva> reservasTerminadas() {

        return repository.reservasFinalizadas();
    }


    public List<Reserva> reservasTerminadasUsuario(Usuario usuario) {

        return repository.reservasFinalizadasUsuario(usuario);
    }
}
