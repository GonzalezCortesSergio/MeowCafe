package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Producto;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Combo;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.repository.RepositorioCombo;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.base.ServicioBaseImpl;

@Service
public class ServicioCombo extends ServicioBaseImpl<Combo, Long, RepositorioCombo>{

    @Autowired
    private ServicioProducto servicioProducto;


    public void addProducto(Combo combo, Producto producto) {

        combo.getProducto().add(producto);

        producto.getCombo().add(combo);

        servicioProducto.edit(producto);
    }

    public void obtenerPrecioCombo(Combo combo) {

        combo.setPrecioCombo(combo.getProducto().stream()
                .mapToDouble(Producto::getPrecio)
                .sum());
    }
}
