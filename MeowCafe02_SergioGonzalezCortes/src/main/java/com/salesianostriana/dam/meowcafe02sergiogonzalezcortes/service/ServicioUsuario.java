package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Usuario;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.repository.RepositorioUsuario;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.base.ServicioBaseImpl;

@Service
public class ServicioUsuario extends ServicioBaseImpl<Usuario, Long, RepositorioUsuario>{

}
