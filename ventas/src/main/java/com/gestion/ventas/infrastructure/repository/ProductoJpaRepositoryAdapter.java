package com.gestion.ventas.infrastructure.repository;

import com.gestion.ventas.dominio.models.Producto;
import com.gestion.ventas.dominio.ports.out.ProductoOut;
import com.gestion.ventas.infrastructure.entity.ProductoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductoJpaRepositoryAdapter implements ProductoOut {
    private final ProductoJpaRepository productoJpaRepository;

    public ProductoJpaRepositoryAdapter(ProductoJpaRepository productoJpaRepository) {
        this.productoJpaRepository = productoJpaRepository;
    }


    @Override
    public Producto addProducto(Producto producto) {
        ProductoEntity productoEntity = ProductoEntity.fromDomainModel(producto);
        return productoJpaRepository.save(productoEntity).toDomainModel();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoJpaRepository.findById(id).map(ProductoEntity::toDomainModel);
    }


    @Override
    public Optional<Producto> updateProducto(Long id, Producto productoActualizado) {
        // para evitar crear nuevos productos cuando id de ruta existe e id de body no existe
        /*
        if(productoJpaRepository.existsById(id) && id == productoActualizado.getId()){
            ProductoEntity productoEntity = ProductoEntity.fromDomainModel(productoActualizado);
            return Optional.of(productoJpaRepository.save(productoEntity).toDomainModel());
        }*/
        if(productoJpaRepository.existsById(id)){
            Producto producto = new Producto();
            producto.setId(id);
            producto.setNombre(productoActualizado.getNombre());
            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setStock(productoActualizado.getStock());

            ProductoEntity productoEntity = ProductoEntity.fromDomainModel(producto);
            return Optional.of(productoJpaRepository.save(productoEntity).toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Boolean deleteProducto(Long id) {
        if(productoJpaRepository.existsById(id)){
            productoJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
