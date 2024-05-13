package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Producto;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.repository.RepositorioProducto;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.base.ServicioBaseImpl;
import org.springframework.stereotype.Service;

@Service
public class ServicioProducto extends ServicioBaseImpl<Producto, Long, RepositorioProducto> {
}
