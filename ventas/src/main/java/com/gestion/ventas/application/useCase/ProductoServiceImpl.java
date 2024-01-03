package com.gestion.ventas.application.useCase;

import com.gestion.ventas.dominio.models.Producto;
import com.gestion.ventas.dominio.ports.in.ProductoIn;
import com.gestion.ventas.dominio.ports.out.ProductoOut;

import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoIn {
    private final ProductoOut productoOut;

    public ProductoServiceImpl(ProductoOut productoOut) {
        this.productoOut = productoOut;
    }

    @Override
    public Producto addProducto(Producto producto) {
        return productoOut.addProducto(producto);
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoOut.findById(id);
    }

    @Override
    public Optional<Producto> updateProducto(Long id, Producto producto) {
        return productoOut.updateProducto(id, producto);
    }

    @Override
    public Boolean deleteProducto(Long id) {
        return productoOut.deleteProducto(id);
    }

}
