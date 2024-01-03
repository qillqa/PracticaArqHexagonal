package com.gestion.ventas.application.service;

import com.gestion.ventas.dominio.models.Producto;
import com.gestion.ventas.dominio.ports.in.ProductoIn;

import java.util.List;
import java.util.Optional;

public class ProductoService implements ProductoIn {
    private final ProductoIn productoIn;

    public ProductoService(ProductoIn productoIn) {
        this.productoIn = productoIn;
    }

    @Override
    public Producto addProducto(Producto producto) {
        return productoIn.addProducto(producto);
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoIn.findById(id);
    }

    @Override
    public Optional<Producto> updateProducto(Long id, Producto producto) {
        return productoIn.updateProducto(id, producto);
    }

    @Override
    public Boolean deleteProducto(Long id) {
        return productoIn.deleteProducto(id);
    }

}
