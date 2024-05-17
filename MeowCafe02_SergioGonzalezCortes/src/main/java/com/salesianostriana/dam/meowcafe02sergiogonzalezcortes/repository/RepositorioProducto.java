package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.repository;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.Producto;
import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositorioProducto extends JpaRepository<Producto, Long> {

    @Query("""
            SELECT p
            FROM Producto p
            WHERE TYPE(p) = Producto AND p.tipoProducto = :tipoProducto
            """)
    public List<Producto> productosTipo(@Param("tipoProducto") TipoProducto tipoProducto);
}
