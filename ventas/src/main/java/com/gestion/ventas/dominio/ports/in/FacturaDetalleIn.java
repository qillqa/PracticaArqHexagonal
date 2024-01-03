package com.gestion.ventas.dominio.ports.in;

import com.gestion.ventas.dominio.models.FacturaDetalle;

import java.util.Optional;

public interface FacturaDetalleIn {
    FacturaDetalle addFacturaDetalle(FacturaDetalle facturaDetalle);
    Optional<FacturaDetalle> findById(Long id);
    Optional<FacturaDetalle> updateFacturaDetalle(Long id, FacturaDetalle facturaDetalle);
    Boolean deleteFacturaDetalle(Long id);
}
