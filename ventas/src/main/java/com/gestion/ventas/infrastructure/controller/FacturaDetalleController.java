package com.gestion.ventas.infrastructure.controller;

import com.gestion.ventas.application.service.FacturaDetalleService;
import com.gestion.ventas.dominio.models.FacturaDetalle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/facturaDetalle")
public class FacturaDetalleController {
    private final FacturaDetalleService facturaDetalleService;

    public FacturaDetalleController(FacturaDetalleService facturaDetalleService) {
        this.facturaDetalleService = facturaDetalleService;
    }

    @PostMapping
    public ResponseEntity<FacturaDetalle> crearFacturaDetalle(@RequestBody FacturaDetalle facturaDetalle){
        FacturaDetalle nuevoFacturaDetalle = facturaDetalleService.addFacturaDetalle(facturaDetalle);
        return new ResponseEntity<>(nuevoFacturaDetalle, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FacturaDetalle> obtenerFacturaDetallePorId(@PathVariable Long id){
        return facturaDetalleService.findById(id)
                .map(facturaDetalleItem -> new ResponseEntity<>(facturaDetalleItem,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturaDetalle> actualizarFacturaDetalle(@PathVariable Long id, @RequestBody FacturaDetalle facturaDetalleActualizado) {
        Optional<FacturaDetalle> facturaDetalleActualizadoResult = facturaDetalleService.updateFacturaDetalle(id, facturaDetalleActualizado);

        return facturaDetalleActualizadoResult
                .map(facturaDetalleItem -> new ResponseEntity<>(facturaDetalleItem, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFacturaDetallePorId(@PathVariable Long id) {
        if (facturaDetalleService.deleteFacturaDetalle(id)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
