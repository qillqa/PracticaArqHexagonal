package com.gestion.ventas.infrastructure.repository;

import com.gestion.ventas.dominio.models.FacturaCabecera;
import com.gestion.ventas.dominio.ports.out.FacturaCabeceraOut;
import com.gestion.ventas.infrastructure.entity.FacturaCabeceraEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FacturaCabeceraJpaRepositoryAdapter implements FacturaCabeceraOut {
    private final FacturaCabeceraJpaRepository facturaCabeceraJpaRepository;

    public FacturaCabeceraJpaRepositoryAdapter(FacturaCabeceraJpaRepository facturaCabeceraJpaRepository) {
        this.facturaCabeceraJpaRepository = facturaCabeceraJpaRepository;
    }


    @Override
    public FacturaCabecera addFacturaCabecera(FacturaCabecera facturaCabecera) {
        FacturaCabeceraEntity facturaCabeceraEntity = FacturaCabeceraEntity.fromDomainModel(facturaCabecera);
        return facturaCabeceraJpaRepository.save(facturaCabeceraEntity).toDomainModel();
    }

    @Override
    public Optional<FacturaCabecera> findById(Long id) {
        return facturaCabeceraJpaRepository.findById(id).map(FacturaCabeceraEntity::toDomainModel);
    }

    @Override
    public Optional<FacturaCabecera> updateFacturaCabecera(Long id, FacturaCabecera facturaCabeceraActualizado) {
        if(facturaCabeceraJpaRepository.existsById(id)){
            /*
            FacturaCabecera facturaCabecera = new FacturaCabecera();
            facturaCabecera.setId(id);
            facturaCabecera.setClienteNombre(facturaCabeceraActualizado.getClienteNombre());
            facturaCabecera.setClienteNumDocumento(facturaCabeceraActualizado.getClienteNumDocumento());
            facturaCabecera.setFechaEmision(facturaCabeceraActualizado.getFechaEmision());
            facturaCabecera.setTotal(facturaCabeceraActualizado.getTotal());
            */

            Optional<FacturaCabeceraEntity> facturaCabeceraEntityExiste = facturaCabeceraJpaRepository.findById(id);
            // FacturaCabeceraEntity facturaCabeceraExiste = facturaCabeceraEntityExiste.get();
            FacturaCabecera facturaCabeceraExiste = facturaCabeceraEntityExiste.get().toDomainModel();

            FacturaCabecera facturaCabecera = new FacturaCabecera();
            facturaCabecera.setId(id);

            facturaCabecera.setClienteNombre(facturaCabeceraActualizado.getClienteNombre());
            facturaCabecera.setClienteNumDocumento(facturaCabeceraActualizado.getClienteNumDocumento());

            facturaCabecera.setFechaEmision(facturaCabeceraExiste.getFechaEmision());
            facturaCabecera.setTotal(facturaCabeceraExiste.getTotal());

            // facturaCabecera.set(facturaCabeceraExiste.getTotal());

            FacturaCabeceraEntity facturaCabeceraEntity = FacturaCabeceraEntity.fromDomainModel(facturaCabecera);
            return Optional.of(facturaCabeceraJpaRepository.save(facturaCabeceraEntity).toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Boolean deleteFacturaCabecera(Long id) {
        if(facturaCabeceraJpaRepository.existsById(id)){
            facturaCabeceraJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
