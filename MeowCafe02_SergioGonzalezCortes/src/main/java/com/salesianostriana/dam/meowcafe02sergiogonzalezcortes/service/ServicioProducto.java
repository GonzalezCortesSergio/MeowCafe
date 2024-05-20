package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Producto;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.TipoProducto;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.repository.RepositorioProducto;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.base.ServicioBaseImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioProducto extends ServicioBaseImpl<Producto, Long, RepositorioProducto> {

    public List<Producto> productosTipo(TipoProducto tipoProducto) {

        return repository.productosTipo(tipoProducto);
    }


    public List<Producto> soloProductos() {

        return repository.soloProductos(TipoProducto.SINPRODUCTO);
    }

}
