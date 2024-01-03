package com.gestion.ventas.dominio.ports.in;

import com.gestion.ventas.dominio.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoIn {
    Producto addProducto(Producto producto);
    Optional<Producto> findById(Long id);
    Optional<Producto> updateProducto(Long id, Producto producto);
    Boolean deleteProducto(Long id);
}
