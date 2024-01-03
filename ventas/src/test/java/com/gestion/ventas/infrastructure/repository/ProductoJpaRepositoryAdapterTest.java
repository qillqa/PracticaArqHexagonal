package com.gestion.ventas.infrastructure.repository;

import com.gestion.ventas.dominio.models.Producto;
import com.gestion.ventas.infrastructure.entity.ProductoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class ProductoJpaRepositoryAdapterTest {

    @Mock
    ProductoJpaRepository productoJpaRepository;

    @InjectMocks
    ProductoJpaRepositoryAdapter productoJpaRepositoryAdapter;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        productoJpaRepositoryAdapter = new ProductoJpaRepositoryAdapter(productoJpaRepository);
    }

    @Test
    void addProducto() {
        // public Producto addProducto(Producto producto) {
        // ProductoEntity productoEntity = ProductoEntity.fromDomainModel(producto);
        // return productoJpaRepository.save(productoEntity).toDomainModel();

        // preparar
        Producto producto = new Producto(1L, "Chocolate", "Chocolate de taza 100gr", 3.5, 50);
        ProductoEntity productoEntity = new ProductoEntity(1L, "Chocolate", "Chocolate de taza 100gr", 3.5, 50);

        // simular & ejecutar
        Mockito.when(productoJpaRepository.save(Mockito.any(ProductoEntity.class))).thenReturn(productoEntity);
        Producto productoAdapter = productoJpaRepositoryAdapter.addProducto(producto);

        // afirmar
        assertNotNull(productoAdapter);
        assertEquals(producto.getId(), productoAdapter.getId());
    }

    @Test
    void findById() {
    }

    @Test
    void updateProducto() {
    }

    @Test
    void deleteProducto() {
    }
}