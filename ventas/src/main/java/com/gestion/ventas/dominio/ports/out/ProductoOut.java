package com.gestion.ventas.dominio.ports.out;

import com.gestion.ventas.dominio.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoOut {
    Producto addProducto(Producto producto);
    Optional<Producto> findById(Long id);
    Optional<Producto> updateProducto(Long id, Producto producto);
    Boolean deleteProducto(Long id);
}
