package com.proyectoelena.service;

import com.proyectoelena.domain.Pago;
import com.proyectoelena.domain.enums.EstadoPago;
import com.proyectoelena.domain.enums.MetodoPago;
import com.proyectoelena.repository.PagoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.Set;

@Service
public class PagoService {
    private final PagoRepository pagoRepository;
    private final EmailNotificationService emailNotificationService;

    public PagoService(PagoRepository pagoRepository, EmailNotificationService emailNotificationService) {
        this.pagoRepository = pagoRepository;
        this.emailNotificationService = emailNotificationService;
    }

    public Pago registrarPago(String usuarioId, String eventoId, Double monto, MetodoPago metodo, String comprobanteUrl) {
        if (metodo == MetodoPago.TRANSFERENCIA || metodo == MetodoPago.TARJETA) {
            if (StringUtils.hasText(comprobanteUrl)) {
                validarComprobante(comprobanteUrl);
            }
        }
        Pago p = new Pago();
        p.setUsuarioId(usuarioId);
        p.setEventoId(eventoId);
        p.setMonto(monto);
        p.setMetodoPago(metodo);
        p.setComprobanteUrl(comprobanteUrl);
        p.setEstado(EstadoPago.PENDIENTE);
        p.setFechaPago(Instant.now());
        Pago saved = pagoRepository.save(p);
        emailNotificationService.enqueueEmail(usuarioId, "Pago", "Pago registrado");
        return saved;
    }

    public Pago validarPago(String pagoId, String adminId, boolean aprobado) {
        Pago p = pagoRepository.findById(pagoId).orElseThrow(() -> new IllegalArgumentException("pago"));
        p.setEstado(aprobado ? EstadoPago.VALIDADO : EstadoPago.PENDIENTE);
        p.setValidadoPorId(aprobado ? adminId : null);
        p.setFechaValidacion(Instant.now());
        Pago saved = pagoRepository.save(p);
        emailNotificationService.enqueueEmail(p.getUsuarioId(), "Pago", "Estado de pago actualizado");
        return saved;
    }

    private void validarComprobante(String url) {
        Set<String> permitidas = Set.of(".pdf", ".jpg", ".jpeg", ".png");
        String l = url.toLowerCase();
        boolean ok = permitidas.stream().anyMatch(l::endsWith);
        if (!ok) throw new IllegalArgumentException("comprobante invalido");
    }
}
