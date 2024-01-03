package com.gestion.ventas.dominio.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDetalle {
    private Long id;
    private Long facturaId;
    private Long productoId;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;

}
