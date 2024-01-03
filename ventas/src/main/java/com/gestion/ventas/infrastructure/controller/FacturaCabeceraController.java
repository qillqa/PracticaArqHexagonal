package com.gestion.ventas.infrastructure.controller;

import com.gestion.ventas.application.service.FacturaCabeceraService;
import com.gestion.ventas.dominio.models.FacturaCabecera;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/facturaCabecera")
public class FacturaCabeceraController {
    private final FacturaCabeceraService facturaCabeceraService;

    public FacturaCabeceraController(FacturaCabeceraService facturaCabeceraService) {
        this.facturaCabeceraService = facturaCabeceraService;
    }

    @PostMapping
    public ResponseEntity<FacturaCabecera> crearFacturaCabecera(@RequestBody FacturaCabecera facturaCabecera){
        FacturaCabecera nuevoFacturaCabecera = facturaCabeceraService.addFacturaCabecera(facturaCabecera);
        return new ResponseEntity<>(nuevoFacturaCabecera, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FacturaCabecera> obtenerFacturaCabeceraPorId(@PathVariable Long id){
        return facturaCabeceraService.findById(id)
                .map(facturaCabeceraItem -> new ResponseEntity<>(facturaCabeceraItem,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturaCabecera> actualizarFacturaCabecera(@PathVariable Long id, @RequestBody FacturaCabecera facturaCabeceraActualizado) {
        Optional<FacturaCabecera> facturaCabeceraActualizadoResult = facturaCabeceraService.updateFacturaCabecera(id, facturaCabeceraActualizado);

        return facturaCabeceraActualizadoResult
                .map(facturaCabeceraItem -> new ResponseEntity<>(facturaCabeceraItem, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFacturaCabeceraPorId(@PathVariable Long id) {
        if (facturaCabeceraService.deleteFacturaCabecera(id)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
