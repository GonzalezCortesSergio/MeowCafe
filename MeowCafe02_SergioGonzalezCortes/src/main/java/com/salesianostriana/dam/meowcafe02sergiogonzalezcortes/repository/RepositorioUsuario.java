package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.repository;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{

    Optional<Usuario> findFirstByUsername(String username);

    @Query("""
            SELECT u
            FROM Usuario u
            WHERE u.tipo = :tipo
            """)
    public List<Usuario> usuarioTipo(@Param("tipo") TipoUsuario tipo);
}
