package com.gestion.ventas.application.useCase;

import com.gestion.ventas.dominio.models.FacturaDetalle;
import com.gestion.ventas.dominio.ports.in.FacturaDetalleIn;
import com.gestion.ventas.dominio.ports.out.FacturaDetalleOut;

import java.util.Optional;

public class FacturaDetalleServiceImpl implements FacturaDetalleIn {
    private final FacturaDetalleOut facturaDetalleOut;

    public FacturaDetalleServiceImpl(FacturaDetalleOut facturaDetalleOut) {
        this.facturaDetalleOut = facturaDetalleOut;
    }

    @Override
    public FacturaDetalle addFacturaDetalle(FacturaDetalle facturaDetalle) {
        return facturaDetalleOut.addFacturaDetalle(facturaDetalle);
    }

    @Override
    public Optional<FacturaDetalle> findById(Long id) {
        return facturaDetalleOut.findById(id);
    }

    @Override
    public Optional<FacturaDetalle> updateFacturaDetalle(Long id, FacturaDetalle facturaDetalle) {
        return facturaDetalleOut.updateFacturaDetalle(id, facturaDetalle);
    }

    @Override
    public Boolean deleteFacturaDetalle(Long id) {
        return facturaDetalleOut.deleteFacturaDetalle(id);
    }
}
