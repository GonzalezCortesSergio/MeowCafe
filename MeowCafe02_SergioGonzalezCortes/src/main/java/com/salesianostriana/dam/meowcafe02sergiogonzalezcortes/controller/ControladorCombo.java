package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.controller;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Combo;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Producto;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.TipoProducto;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioCombo;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ControladorCombo {

    @Autowired
    private ServicioCombo servicioCombo;

    @Autowired
    private ServicioProducto servicioProducto;



    //Cliente

    @GetMapping("/cliente/combos")
    public String mostrarCombos(Model model) {

        model.addAttribute("combos", servicioCombo.findAll());

        return "cliente/combos";
    }


    //Admin

    @GetMapping("/admin/combos")
    public String mostrarCombosAdmin(Model model) {

        model.addAttribute("combos", servicioCombo.findAll());

        return "admin/combos";

    }

    @GetMapping("/admin/formularioCombo")
    public String formularioCombo(Model model) {

        model.addAttribute("combo", new Combo());
        model.addAttribute("productos", servicioProducto.soloProductos());

        return "admin/formularioCombos";
    }

    @PostMapping("/admin/formularioCombo/agregar")
    public String agregarCombo(@ModelAttribute("combo")Combo combo, @RequestParam(required = false) ArrayList<Long> listaIdProductos) {

        if (listaIdProductos != null)
            for (Long id : listaIdProductos) {

                Optional<Producto> producto = servicioProducto.findById(id);

                producto.ifPresent(p -> p.addToCombo(combo));

            }

        servicioCombo.obtenerPrecioCombo(combo);

        servicioCombo.save(combo);


        return "redirect:/admin/combos";
    }

    @GetMapping("/admin/formularioCombo/{id}")
    public String formularioEditarCombo(@PathVariable("id") Long id, Model model) {

        Optional<Combo> combo = servicioCombo.findById(id);

        if (combo.isPresent()) {


            model.addAttribute("combo", combo.get());
            model.addAttribute("productos", servicioProducto.soloProductos());

            return "admin/formularioEditarCombo";
        }

        return "redirect:/admin/combos";
    }

    @PostMapping("/admin/formularioCombo/editar")
    public String editarCombo(@ModelAttribute("combo") Combo combo, @RequestParam(required = false) ArrayList<Long> listaIdProductos) {

        if (listaIdProductos != null)

            for (Long id : listaIdProductos) {

                Optional<Producto> producto = servicioProducto.findById(id);

                producto.ifPresent(p -> p.addToCombo(combo));

            }

        servicioCombo.obtenerPrecioCombo(combo);

        servicioCombo.edit(combo);
        return "redirect:/admin/combos";
    }


    @GetMapping("/admin/borrarCombo/{id}")
    public String borrarCombo(@PathVariable("id") Long id) {

        if (servicioCombo.findById(id).isPresent()) {
            Combo aEliminar = servicioCombo.findById(id).get();
            if (!aEliminar.getProductos().isEmpty())
                for (int i = aEliminar.getProductos().size() - 1; i > 0; i--) {

                    aEliminar.getProductos().get(i).removeFromCombo(aEliminar);
                }

            servicioCombo.delete(aEliminar);
        }

        return "redirect:/admin/combos";
    }
}
