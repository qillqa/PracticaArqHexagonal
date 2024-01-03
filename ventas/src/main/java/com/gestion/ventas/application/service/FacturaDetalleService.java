package com.gestion.ventas.application.service;

import com.gestion.ventas.dominio.models.FacturaDetalle;
import com.gestion.ventas.dominio.ports.in.FacturaDetalleIn;

import java.util.Optional;

public class FacturaDetalleService implements FacturaDetalleIn {
    private final FacturaDetalleIn facturaDetalleIn;

    public FacturaDetalleService(FacturaDetalleIn facturaDetalleIn) {
        this.facturaDetalleIn = facturaDetalleIn;
    }

    @Override
    public FacturaDetalle addFacturaDetalle(FacturaDetalle facturaDetalle) {
        return facturaDetalleIn.addFacturaDetalle(facturaDetalle);
    }

    @Override
    public Optional<FacturaDetalle> findById(Long id) {
        return facturaDetalleIn.findById(id);
    }

    @Override
    public Optional<FacturaDetalle> updateFacturaDetalle(Long id, FacturaDetalle facturaDetalle) {
        return facturaDetalleIn.updateFacturaDetalle(id, facturaDetalle);
    }

    @Override
    public Boolean deleteFacturaDetalle(Long id) {
        return facturaDetalleIn.deleteFacturaDetalle(id);
    }
}
