package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.controller;

import com.itextpdf.text.DocumentException;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.*;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.pdf.PdfGenerator;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.security.PasswordGenerator;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioCombo;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioGato;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioProducto;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@Controller
@RequestMapping("/admin")
public class ControladorAdmin {

    //Atributos


    @Autowired
    private ServicioUsuario servicioUsuario;





    @GetMapping("/clientes")
    public String mostrarClientesRegistrados(Model model) {

        model.addAttribute("clientes", servicioUsuario.usuarioTipo(TipoUsuario.CLIENTE));


        return "admin/clientes";
    }

    @GetMapping("/cambiarPremium/{id}")
    public String cambiarPremium(@PathVariable("id") long id, Model model) {

        if(servicioUsuario.findById(id).isPresent()) {

            Usuario usuario = servicioUsuario.findById(id).get();

            model.addAttribute("usuario", usuario);

            return "admin/formularioCambiarPremiumCliente";
        }

        return "redirect:/admin/clientes";
    }

    @PostMapping("/cambiarPremium/submit")
    public String clienteCambiado(@ModelAttribute("usuario") Usuario usuario) {

        servicioUsuario.edit(usuario);

        return "redirect:/admin/clientes";
    }




    //Registro de nuevo usuario

    @GetMapping("/reserva")
    public String registraUnNuevoUsuario(Model model) {

        model.addAttribute("usuario", new Usuario());

        return "admin/clienteNuevoAdmin";

    }

    @PostMapping("/nuevoCliente")
    public String guardaElCliente(@ModelAttribute("usuario") Usuario usuario, Model model) throws IOException, DocumentException {

        String contrasenaGenerada = PasswordGenerator.getPassword(PasswordGenerator.MINUSCULAS + PasswordGenerator.NUMEROS, 8);

        usuario.setPassword(servicioUsuario.codificarContrasena(contrasenaGenerada));

        usuario.setTipo(TipoUsuario.CLIENTE);

        servicioUsuario.save(usuario);


        model.addAttribute("usuario", usuario);
        model.addAttribute("password", contrasenaGenerada);



        return "admin/pdfUsuario";

    }



}
