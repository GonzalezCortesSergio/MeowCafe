package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.controller;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Producto;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.TipoProducto;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorProducto {


    @Autowired
    private ServicioProducto servicioProducto;


    @GetMapping("/cliente/productos")
    public String mostrarProductos(Model model) {

        model.addAttribute("bebidas", servicioProducto.productosTipo(TipoProducto.COMIDA));
        model.addAttribute("comidas", servicioProducto.productosTipo(TipoProducto.BEBIDA));

        return "cliente/productos";
    }



    @GetMapping("/admin/productos")
    public String mostrarProductosAdmin(Model model) {

        model.addAttribute("productos", servicioProducto.soloProductos());

        return "admin/productos";
    }

    @GetMapping("/admin/formularioProductos")
    public String formularioProductos(Model model) {

        model.addAttribute("producto", new Producto());

        return "admin/formularioProductos";
    }

    @PostMapping("/admin/formularioProductos/agregar")
    public String guardarProductoNuevo(@ModelAttribute("producto") Producto producto) {

        servicioProducto.save(producto);

        return "redirect:/admin/productos";
    }

    @GetMapping("/admin/formularioProductos/{id}")
    public String formularioEditarProductos(@PathVariable("id") Long id, Model model) {

        if(servicioProducto.findById(id).isPresent()){

            model.addAttribute("producto", servicioProducto.findById(id).get());

            return "admin/formularioEditarProductos";
        }

        return "redirect:/admin/productos";

    }

    @PostMapping("/admin/formularioProductos/editar")
    public String editarProducto(@ModelAttribute("producto") Producto producto) {

        servicioProducto.edit(producto);

        return "redirect:/admin/productos";
    }

    @GetMapping("/admin/borrarProducto/{id}")
    public String borrarProducto(@PathVariable("id") long id) {

        if(servicioProducto.findById(id).isPresent()) {
            servicioProducto.deleteById(id);
        }
        return "redirect:/admin/productos";
    }
}
