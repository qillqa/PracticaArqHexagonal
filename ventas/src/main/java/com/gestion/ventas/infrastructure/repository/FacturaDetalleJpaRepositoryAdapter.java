package com.gestion.ventas.infrastructure.repository;

import com.gestion.ventas.dominio.models.FacturaDetalle;
import com.gestion.ventas.dominio.models.Producto;
import com.gestion.ventas.dominio.ports.out.FacturaDetalleOut;
import com.gestion.ventas.infrastructure.entity.FacturaDetalleEntity;
import com.gestion.ventas.infrastructure.entity.ProductoEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FacturaDetalleJpaRepositoryAdapter implements FacturaDetalleOut {
    private final FacturaDetalleJpaRepository facturaDetalleJpaRepository;
    private final ProductoJpaRepository productoJpaRepository;

    public FacturaDetalleJpaRepositoryAdapter(FacturaDetalleJpaRepository facturaDetalleJpaRepository, ProductoJpaRepository productoJpaRepository) {
        this.facturaDetalleJpaRepository = facturaDetalleJpaRepository;
        this.productoJpaRepository = productoJpaRepository;
    }

    @Override
    public FacturaDetalle addFacturaDetalle(FacturaDetalle facturaDetalle) {
        FacturaDetalle facturaDetalleNuevo = new FacturaDetalle();

        Long productoId = facturaDetalle.getProductoId();

        Double precioUnitario = null;
        Integer cantidad = null;
        Double subtotal = null;

        if(productoJpaRepository.existsById(productoId)){
            Optional<ProductoEntity> productoEntity = productoJpaRepository.findById(productoId);
            precioUnitario = productoEntity.get().getPrecio();
            if(productoEntity.get().getStock() >= facturaDetalle.getCantidad()){
                cantidad = facturaDetalle.getCantidad();
                subtotal = precioUnitario * cantidad;
            }
        }
        facturaDetalleNuevo.setFacturaId(facturaDetalle.getFacturaId());
        facturaDetalleNuevo.setProductoId(facturaDetalle.getProductoId());
        facturaDetalleNuevo.setPrecioUnitario(precioUnitario);
        facturaDetalleNuevo.setCantidad(cantidad);
        facturaDetalleNuevo.setSubtotal(subtotal);

        FacturaDetalleEntity facturaDetalleEntity = FacturaDetalleEntity.fromDomainModel(facturaDetalleNuevo);
        return facturaDetalleJpaRepository.save(facturaDetalleEntity).toDomainModel();
    }

    @Override
    public Optional<FacturaDetalle> findById(Long id) {
        return facturaDetalleJpaRepository.findById(id).map(FacturaDetalleEntity::toDomainModel);
    }

    @Override
    public Optional<FacturaDetalle> updateFacturaDetalle(Long id, FacturaDetalle facturaDetalleActualizado) {
        if(facturaDetalleJpaRepository.existsById(id)){
            Optional<FacturaDetalleEntity> facturaDetalleEntityExiste = facturaDetalleJpaRepository.findById(id);

            FacturaDetalleEntity facturaDetalleExiste = facturaDetalleEntityExiste.get();

            FacturaDetalle facturaDetalle = new FacturaDetalle();

            facturaDetalle.setId(id);
            facturaDetalle.setFacturaId(facturaDetalleExiste.getFacturaId());
            facturaDetalle.setProductoId(facturaDetalleExiste.getProductoId());

            facturaDetalle.setCantidad(facturaDetalleActualizado.getCantidad());

            facturaDetalle.setPrecioUnitario(facturaDetalleExiste.getPrecioUnitario());
            facturaDetalle.setSubtotal(facturaDetalleExiste.getPrecioUnitario() * facturaDetalleActualizado.getCantidad());

            FacturaDetalleEntity facturaDetalleEntity = FacturaDetalleEntity.fromDomainModel(facturaDetalle);
            return Optional.of(facturaDetalleJpaRepository.save(facturaDetalleEntity).toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Boolean deleteFacturaDetalle(Long id) {
        if(facturaDetalleJpaRepository.existsById(id)){
            facturaDetalleJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
