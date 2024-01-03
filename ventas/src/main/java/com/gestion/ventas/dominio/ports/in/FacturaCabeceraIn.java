package com.gestion.ventas.dominio.ports.in;

import com.gestion.ventas.dominio.models.FacturaCabecera;

import java.util.Optional;

public interface FacturaCabeceraIn {
    FacturaCabecera addFacturaCabecera(FacturaCabecera facturaCabecera);
    Optional<FacturaCabecera> findById(Long id);
    Optional<FacturaCabecera> updateFacturaCabecera(Long id, FacturaCabecera facturaCabecera);
    Boolean deleteFacturaCabecera(Long id);
}
