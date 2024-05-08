package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Producto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Combo;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.repository.RepositorioCombo;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.base.ServicioBaseImpl;

@Service
public class ServicioCombo extends ServicioBaseImpl<Combo, Long, RepositorioCombo>{

    @PostConstruct
    public void calcularPrecioCombo () {

        for (Combo combo : this.findAll()) {

            combo.setPrecioCombo(combo.getProductos()
                    .stream()
                    .mapToDouble(Producto::getPrecio)
                    .sum());
        }
    }
}
