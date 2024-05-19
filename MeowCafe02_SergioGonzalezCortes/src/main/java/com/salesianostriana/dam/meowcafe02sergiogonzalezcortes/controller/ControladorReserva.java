package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.controller;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Reserva;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioLineaReserva;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorReserva {

    @Autowired
    private ServicioLineaReserva servicioLineaReserva;

    @Autowired
    private ServicioReserva servicioReserva;


    @PostMapping("/cliente/reserva/terminarReserva")
    public String terminarReserva(@ModelAttribute("reserva") Reserva reserva) {

        servicioReserva.terminarReserva(reserva);
        servicioReserva.save(reserva);


        return "redirect:/cliente/index";
    }

    @GetMapping("/admin/reservas")
    public String reservasAdmin(Model model) {

        model.addAttribute("reservas", servicioReserva.reservasTerminadas());

        return "admin/reservas";
    }



}
