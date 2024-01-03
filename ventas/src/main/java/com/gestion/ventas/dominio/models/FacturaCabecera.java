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
public class FacturaCabecera {
    private Long id;
    private String clienteNombre;
    private String clienteNumDocumento;
    private Date fechaEmision;
    private Double total;

}
