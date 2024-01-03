package com.gestion.ventas.application.service;

import com.gestion.ventas.dominio.models.FacturaCabecera;
import com.gestion.ventas.dominio.ports.in.FacturaCabeceraIn;

import java.util.Optional;

public class FacturaCabeceraService implements FacturaCabeceraIn {
    private final FacturaCabeceraIn facturaCabeceraIn;

    public FacturaCabeceraService(FacturaCabeceraIn facturaCabeceraIn) {
        this.facturaCabeceraIn = facturaCabeceraIn;
    }

    @Override
    public FacturaCabecera addFacturaCabecera(FacturaCabecera facturaCabecera) {
        return facturaCabeceraIn.addFacturaCabecera(facturaCabecera);
    }

    @Override
    public Optional<FacturaCabecera> findById(Long id) {
        return facturaCabeceraIn.findById(id);
    }

    @Override
    public Optional<FacturaCabecera> updateFacturaCabecera(Long id, FacturaCabecera facturaCabecera) {
        return facturaCabeceraIn.updateFacturaCabecera(id, facturaCabecera);
    }

    @Override
    public Boolean deleteFacturaCabecera(Long id) {
        return facturaCabeceraIn.deleteFacturaCabecera(id);
    }
}
