package com.gestion.ventas.infrastructure.entity;

import com.gestion.ventas.dominio.models.FacturaCabecera;
import com.gestion.ventas.dominio.models.FacturaDetalle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "facturacabecera")
@NoArgsConstructor
@AllArgsConstructor
public class FacturaCabeceraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "factura_id")
    private Long id;
    @Column(name = "cliente_nombre")
    private String clienteNombre;
    @Column(name = "cliente_num_documento")
    private String clienteNumDocumento;
    @Column(name = "fecha_emision")
    private Date fechaEmision;
    private Double total;

    /*
    @OneToMany(mappedBy = "facturaCabeceraEntity", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<FacturaDetalleEntity> facturaDetalleEntityList;
    */

    public static FacturaCabeceraEntity fromDomainModel(FacturaCabecera facturaCabecera) {
        FacturaCabeceraEntity facturaCabeceraEntity = new FacturaCabeceraEntity();
        facturaCabeceraEntity.setId(facturaCabecera.getId());
        facturaCabeceraEntity.setClienteNombre(facturaCabecera.getClienteNombre());
        facturaCabeceraEntity.setClienteNumDocumento(facturaCabecera.getClienteNumDocumento());
        facturaCabeceraEntity.setFechaEmision(facturaCabecera.getFechaEmision());
        facturaCabeceraEntity.setTotal(facturaCabecera.getTotal());

        return facturaCabeceraEntity;
    }

    public FacturaCabecera toDomainModel() {
        FacturaCabecera facturaCabecera = new FacturaCabecera();
        facturaCabecera.setId(this.id);
        facturaCabecera.setClienteNombre(this.clienteNombre);
        facturaCabecera.setClienteNumDocumento(this.clienteNumDocumento);
        facturaCabecera.setFechaEmision(this.fechaEmision);
        facturaCabecera.setTotal(this.total);

        return facturaCabecera;
    }
}
