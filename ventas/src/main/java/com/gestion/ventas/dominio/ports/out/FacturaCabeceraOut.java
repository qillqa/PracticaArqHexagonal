package com.gestion.ventas.dominio.ports.out;

import com.gestion.ventas.dominio.models.FacturaCabecera;

import java.util.Optional;

public interface FacturaCabeceraOut {
    FacturaCabecera addFacturaCabecera(FacturaCabecera facturaCabecera);
    Optional<FacturaCabecera> findById(Long id);
    Optional<FacturaCabecera> updateFacturaCabecera(Long id, FacturaCabecera facturaCabecera);
    Boolean deleteFacturaCabecera(Long id);
}
