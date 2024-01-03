package com.gestion.ventas.infrastructure.config;

import com.gestion.ventas.application.service.FacturaDetalleService;
import com.gestion.ventas.application.service.ProductoService;
import com.gestion.ventas.application.service.FacturaCabeceraService;
import com.gestion.ventas.application.useCase.FacturaDetalleServiceImpl;
import com.gestion.ventas.application.useCase.ProductoServiceImpl;
import com.gestion.ventas.application.useCase.FacturaCabeceraServiceImpl;
import com.gestion.ventas.dominio.ports.out.FacturaDetalleOut;
import com.gestion.ventas.dominio.ports.out.ProductoOut;
import com.gestion.ventas.dominio.ports.out.FacturaCabeceraOut;
import com.gestion.ventas.infrastructure.repository.FacturaCabeceraJpaRepositoryAdapter;
import com.gestion.ventas.infrastructure.repository.FacturaDetalleJpaRepositoryAdapter;
import com.gestion.ventas.infrastructure.repository.ProductoJpaRepositoryAdapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ProductoService productoService (ProductoOut productoOut) {
        return new ProductoService(new ProductoServiceImpl(productoOut));
    }

    @Bean
    public ProductoOut productoOut (ProductoJpaRepositoryAdapter productoJpaRepositoryAdapter) {
        return productoJpaRepositoryAdapter;
    }

    @Bean
    public FacturaCabeceraService facturaCabeceraService (FacturaCabeceraOut facturaCabeceraOut) {
        return new FacturaCabeceraService(new FacturaCabeceraServiceImpl(facturaCabeceraOut));
    }

    @Bean
    public FacturaCabeceraOut facturaCabeceraOut (FacturaCabeceraJpaRepositoryAdapter facturaCabeceraJpaRepositoryAdapter) {
        return facturaCabeceraJpaRepositoryAdapter;
    }

    @Bean
    public FacturaDetalleService facturaDetalleService (FacturaDetalleOut facturaDetalleOut) {
        return new FacturaDetalleService(new FacturaDetalleServiceImpl(facturaDetalleOut));
    }

    @Bean
    public FacturaDetalleOut facturaDetalleOut (FacturaDetalleJpaRepositoryAdapter facturaDetalleJpaRepositoryAdapter) {
        return facturaDetalleJpaRepositoryAdapter;
    }

}
