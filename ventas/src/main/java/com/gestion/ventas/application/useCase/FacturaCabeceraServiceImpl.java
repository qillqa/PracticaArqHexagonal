package com.gestion.ventas.application.useCase;

import com.gestion.ventas.dominio.models.FacturaCabecera;
import com.gestion.ventas.dominio.ports.in.FacturaCabeceraIn;
import com.gestion.ventas.dominio.ports.out.FacturaCabeceraOut;

import java.util.Optional;

public class FacturaCabeceraServiceImpl implements FacturaCabeceraIn {
    private final FacturaCabeceraOut facturaCabeceraOut;

    public FacturaCabeceraServiceImpl(FacturaCabeceraOut facturaCabeceraOut) {
        this.facturaCabeceraOut = facturaCabeceraOut;
    }

    @Override
    public FacturaCabecera addFacturaCabecera(FacturaCabecera facturaCabecera) {
        return facturaCabeceraOut.addFacturaCabecera(facturaCabecera);
    }

    @Override
    public Optional<FacturaCabecera> findById(Long id) {
        return facturaCabeceraOut.findById(id);
    }

    @Override
    public Optional<FacturaCabecera> updateFacturaCabecera(Long id, FacturaCabecera facturaCabecera) {
        return facturaCabeceraOut.updateFacturaCabecera(id, facturaCabecera);
    }

    @Override
    public Boolean deleteFacturaCabecera(Long id) {
        return facturaCabeceraOut.deleteFacturaCabecera(id);
    }
}
