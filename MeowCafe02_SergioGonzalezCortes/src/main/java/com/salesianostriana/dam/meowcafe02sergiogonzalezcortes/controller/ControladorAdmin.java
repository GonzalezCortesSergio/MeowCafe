package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.controller;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.*;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.pdf.PdfGenerator;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.security.PasswordGenerator;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioCombo;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioGato;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioProducto;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


@Controller
@RequestMapping("/admin")
public class ControladorAdmin {

    //Atributos

    @Autowired
    private ServicioGato servicioGato;

    @Autowired
    private ServicioUsuario servicioUsuario;

    @Autowired
    private ServicioProducto servicioProducto;

    @Autowired
    private ServicioCombo servicioCombo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PdfGenerator pdfGenerator;


    //Métodos Gatos
    @GetMapping("/gatos")
    public String mostrarGatitos(Model model) {

        model.addAttribute("gatitos", servicioGato.findAll());

        return "admin/gatitos";
    }

    @GetMapping("/formularioGatos")
    public String formularioGatinios(Model model) {

        Gato gato = new Gato();

        model.addAttribute("gato", gato);

        return "admin/formularioGatitos";
    }


    @PostMapping("/formularioGatos/agregar")
    public String agregarGatinio (@ModelAttribute("gato") Gato gato) {

        servicioGato.save(gato);


        return "redirect:/admin/gatos";
    }


    @GetMapping("/formularioGatos/{id}")
    public String formularioEditar(@PathVariable("id") long id, Model model) {

        if (servicioGato.findById(id).isPresent()) {
            model.addAttribute("gato", servicioGato.findById(id).get());

            return "/admin/formularioGatitos";
        }

        else {

            return "redirect:/admin/gatos";
        }

    }

    @PostMapping("/formularioGatos/editar")
    public String editarGatinio(@ModelAttribute("gato") Gato gato) {

        servicioGato.edit(gato);

        return "redirect:/admin/gatos";
    }

    @GetMapping("/vacunas/{id}")
    public String formularioVacunas(@PathVariable("id") long id, Model model) {

        if (servicioGato.findById(id).isPresent()) {

            model.addAttribute("gato", servicioGato.findById(id).get());
            model.addAttribute("vacuna", new Vacuna());

            return "admin/formularioVacuna";
        }
        else {

            return "redirect:/admin/gatos";
        }
    }

    @PostMapping("/vacunas/ponerVacuna")
    public String ponerVacuna (@ModelAttribute("gato") Gato gato, @ModelAttribute("vacuna") Vacuna vacuna) {

        gato.addVacuna(vacuna);
        servicioGato.cambiarDisponibilidad(gato);
        
        servicioGato.edit(gato);

        return "redirect:/admin/gatos";
    }

    @GetMapping("/borrarGato/{id}")
    public String borrarGato(@PathVariable("id") long id) {

        if (servicioGato.findById(id).isPresent()) {

            servicioGato.deleteById(id);
        }

        return "redirect:/admin/gatos";
    }

    //Métodos Clientes

    @GetMapping("/clientes")
    public String mostrarClientesRegistrados(Model model) {

        model.addAttribute("clientes", servicioUsuario.usuarioTipo(TipoUsuario.CLIENTE));


        return "admin/clientes";
    }


    //Métodos productos

    @GetMapping("/productos")
    public String mostrarProductos(Model model) {

        model.addAttribute("productos", servicioProducto.findAll());

        return "admin/productos";
    }

    @GetMapping("/formularioProductos")
    public String formularioProductos(Model model) {

        model.addAttribute("producto", new Producto());

        return "admin/formularioProductos";
    }

    @PostMapping("/formularioProductos/agregar")
    public String guardarProductoNuevo(@ModelAttribute("producto") Producto producto) {

        servicioProducto.save(producto);

        return "redirect:/admin/productos";
    }

    @GetMapping("/formularioProductos/{id}")
    public String formularioEditarProductos(@PathVariable("id") Long id, Model model) {

        if(servicioProducto.findById(id).isPresent()){

            model.addAttribute("producto", servicioProducto.findById(id).get());

            return "admin/formularioEditarProductos";
        }

        return "redirect:/admin/productos";

    }

    @PostMapping("/formularioProductos/editar")
    public String editarProducto(@ModelAttribute("producto") Producto producto) {

        servicioProducto.edit(producto);

        return "redirect:/admin/productos";
    }

    @GetMapping("/borrarProducto/{id}")
    public String borrarProducto(@PathVariable("id") long id) {

        if(servicioProducto.findById(id).isPresent()) {
            servicioProducto.deleteById(id);
        }
        return "redirect:/admin/productos";
    }


    //Métodos combos

    @GetMapping("/combos")
    public String mostrarCombos(Model model) {

        model.addAttribute("combos", servicioCombo.findAll());

        return "admin/combos";

    }

    @GetMapping("/formularioCombo")
    public String formularioCombo(Model model) {

        model.addAttribute("combo", new Combo());
        model.addAttribute("bebidas",servicioProducto.productosTipo(TipoProducto.BEBIDA));
        model.addAttribute("comidas", servicioProducto.productosTipo(TipoProducto.COMIDA));

        return "admin/formularioCombos";
    }

    @PostMapping("/formularioCombo/agregar")
    public String agregarCombo(@ModelAttribute("combo")Combo combo, @RequestParam("productoId") Long productoId, @RequestParam("productoId-2") Long segundoProductoId) {
        if(servicioProducto.findById(productoId).isPresent() && servicioProducto.findById(segundoProductoId).isPresent()) {

            Producto bebida = servicioProducto.findById(productoId).get();
            Producto comida = servicioProducto.findById(segundoProductoId).get();

            bebida.addToCombo(combo);
            comida.addToCombo(combo);

            servicioCombo.obtenerPrecioCombo(combo);

            servicioCombo.save(combo);
        }



        return "redirect:/admin/combos";
    }

    @GetMapping("/formularioCombo/{id}")
    public String formularioEditarCombo(@PathVariable("id") Long id, Model model) {

        if (servicioCombo.findById(id).isPresent()) {

            model.addAttribute("combo", servicioCombo.findById(id).get());
            model.addAttribute("bebidas",servicioProducto.productosTipo(TipoProducto.BEBIDA));
            model.addAttribute("comidas", servicioProducto.productosTipo(TipoProducto.COMIDA));

            return "admin/formularioEditarCombo";
        }

        return "redirect:/admin/combos";
    }

    @PostMapping("/formularioCombo/editar")
    public String editarCombo(@ModelAttribute("combo") Combo combo, @RequestParam("productoId") long productoId, @RequestParam("productoId-2") long segundoProductoId) {

        if(servicioProducto.findById(productoId).isPresent() && servicioProducto.findById(segundoProductoId).isPresent()) {

            Producto bebida = servicioProducto.findById(productoId).get();
            Producto comida = servicioProducto.findById(segundoProductoId).get();

            bebida.addToCombo(combo);
            comida.addToCombo(combo);

            servicioCombo.obtenerPrecioCombo(combo);

            servicioCombo.edit(combo);
        }
        return "redirect:/admin/combos";
    }


    @GetMapping("/borrarCombo/{id}")
    public String borrarCombo(@PathVariable("id") Long id) {

        if (servicioCombo.findById(id).isPresent()) {
            Combo aEliminar = servicioCombo.findById(id).get();
            for (Producto producto: aEliminar.getProducto()) {

                producto.removeFromCombo(aEliminar);
            }

            servicioCombo.delete(aEliminar);
        }

        return "redirect:/admin/combos";
    }


    //Registro de nuevo usuario

    @GetMapping("/reserva")
    public String registraUnNuevoUsuario(Model model) {

        model.addAttribute("usuario", new Usuario());

        return "admin/clienteNuevoAdmin";

    }

    @PostMapping("/nuevoCliente")
    public void guardaElCliente(@ModelAttribute("usuario") Usuario usuario) throws FileNotFoundException {

        String contrasenaGenerada = PasswordGenerator.getPassword(PasswordGenerator.MINUSCULAS + PasswordGenerator.NUMEROS, 8);

        pdfGenerator.generarPdf(usuario, contrasenaGenerada);

        usuario.setPassword(servicioUsuario.codificarContrasena(contrasenaGenerada));

        usuario.setTipo(TipoUsuario.CLIENTE);

        servicioUsuario.save(usuario);





    }

}
