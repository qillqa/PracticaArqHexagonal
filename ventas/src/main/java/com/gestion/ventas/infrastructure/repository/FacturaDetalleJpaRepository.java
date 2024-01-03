package com.gestion.ventas.infrastructure.repository;

import com.gestion.ventas.infrastructure.entity.FacturaDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDetalleJpaRepository extends JpaRepository<FacturaDetalleEntity, Long> {
}
