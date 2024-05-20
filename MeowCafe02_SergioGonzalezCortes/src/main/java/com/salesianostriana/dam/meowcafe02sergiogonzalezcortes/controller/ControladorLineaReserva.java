package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.controller;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.LineaReserva;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Producto;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Reserva;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Usuario;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioGato;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioLineaReserva;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioProducto;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorLineaReserva {

    @Autowired
    private ServicioLineaReserva servicioLineaReserva;

    @Autowired
    private ServicioReserva servicioReserva;

    @Autowired
    private ServicioProducto servicioProducto;

    @Autowired
    private ServicioGato servicioGato;



    @GetMapping("/cliente/reservaProducto")
    public String lineaReserva(Model model) {

        model.addAttribute("productos", servicioProducto.findAll());
        model.addAttribute("lineaReserva", new LineaReserva());

        return "cliente/reserva";
    }

    @PostMapping("/cliente/reserva/agregarLineaReserva")
    public String agregarLineaReserva(@ModelAttribute("lineaReserva") LineaReserva lineaReserva, @AuthenticationPrincipal Usuario usuario, Model model) {

        servicioLineaReserva.save(lineaReserva);
        Reserva reserva = servicioReserva.getReserva(usuario);
        reserva.addToUsuario(usuario);

        lineaReserva.setSubTotal(servicioLineaReserva.calcularSubTotal(lineaReserva));

        lineaReserva.addToReserva(reserva);
        servicioReserva.save(reserva);
        model.addAttribute("reserva", reserva);
        model.addAttribute("gatosDisponibles", servicioGato.gatosDisponibles());

        return "cliente/detallesReserva";
    }
}
