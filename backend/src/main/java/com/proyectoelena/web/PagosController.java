package com.proyectoelena.web;

import com.proyectoelena.domain.Pago;
import com.proyectoelena.service.PagoService;
import com.proyectoelena.web.dto.RegistrarPagoRequest;
import com.proyectoelena.web.dto.ValidarPagoRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
public class PagosController {
    private final PagoService pagoService;

    public PagosController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @PostMapping
    public ResponseEntity<Pago> registrar(@Valid @RequestBody RegistrarPagoRequest req) {
        return ResponseEntity.ok(pagoService.registrarPago(req.usuarioId(), req.eventoId(), req.monto(), req.metodoPago(), req.comprobanteUrl()));
    }

    @PutMapping("/{id}/validar")
    public ResponseEntity<Pago> validar(@PathVariable String id, @Valid @RequestBody ValidarPagoRequest req) {
        return ResponseEntity.ok(pagoService.validarPago(id, req.adminId(), req.aprobado()));
    }
}
