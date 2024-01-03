package com.gestion.ventas.infrastructure.repository;

import com.gestion.ventas.infrastructure.entity.FacturaCabeceraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaCabeceraJpaRepository extends JpaRepository<FacturaCabeceraEntity, Long> {
}
