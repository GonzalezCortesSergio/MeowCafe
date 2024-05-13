package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Usuario;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.repository.RepositorioUsuario;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.base.ServicioBaseImpl;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioUsuario extends ServicioBaseImpl<Usuario, Long, RepositorioUsuario>{


}
