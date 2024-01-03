package com.gestion.ventas.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.ventas.dominio.models.FacturaCabecera;
import com.gestion.ventas.dominio.models.FacturaDetalle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "facturadetalle")
@NoArgsConstructor
@AllArgsConstructor
public class FacturaDetalleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_id")
    private Long id;
    @Column(name = "factura_id")
    private Long facturaId;
    @Column(name = "producto_id")
    private Long productoId;
    private Integer cantidad;
    @Column(name = "precio_unitario")
    private Double precioUnitario;
    private Double subtotal;

    /*
    @ManyToOne
    @JoinColumn(name = "factura_id")
    private FacturaCabeceraEntity facturaCabeceraEntity;

    @OneToOne
    @JoinColumn(name = "producto_id", unique = true)
    private ProductoEntity productoEntity;
    */

    public static FacturaDetalleEntity fromDomainModel(FacturaDetalle facturaDetalle) {
        FacturaDetalleEntity facturaDetalleEntity = new FacturaDetalleEntity();
        facturaDetalleEntity.setId(facturaDetalle.getId());
        facturaDetalleEntity.setFacturaId(facturaDetalle.getFacturaId());
        facturaDetalleEntity.setProductoId(facturaDetalle.getProductoId());
        facturaDetalleEntity.setCantidad(facturaDetalle.getCantidad());
        facturaDetalleEntity.setPrecioUnitario(facturaDetalle.getPrecioUnitario());
        facturaDetalleEntity.setSubtotal(facturaDetalle.getSubtotal());

        return facturaDetalleEntity;
    }

    public FacturaDetalle toDomainModel() {
        FacturaDetalle facturaDetalle = new FacturaDetalle();
        facturaDetalle.setId(this.id);
        facturaDetalle.setFacturaId(this.facturaId);
        facturaDetalle.setProductoId(this.productoId);
        facturaDetalle.setCantidad(this.cantidad);
        facturaDetalle.setPrecioUnitario(this.precioUnitario);
        facturaDetalle.setSubtotal(this.subtotal);

        return facturaDetalle;
    }
}
