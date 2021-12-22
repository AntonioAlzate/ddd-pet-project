package co.com.sofka.cliente;

import co.com.sofka.generics.Estado;
import co.com.sofka.cliente.events.*;
import co.com.sofka.cliente.values.CuentaId;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class ClienteChange extends EventChange {
    public ClienteChange(Cliente cliente) {

        apply((ClienteCreado event) -> {
            cliente.personaId = event.getPersonaId();
            cliente.direccion = event.getDireccion();
            cliente.referencias = new HashSet<>();
            cliente.estado = Estado.ACTIVO;
            cliente.cuenta = new Cuenta(new CuentaId());
        });

        apply((ReferenciaAgregada event) -> {
            var numeroReferencias = cliente.referencias.size();
            if(numeroReferencias == 5){
                throw new IllegalArgumentException("No se pueden agregar más de referencias el maximo son 5");
            }

            cliente.referencias.add(new Referencia(
                    event.getEntityId(),
                    event.getNombre(),
                    event.getTelefono(),
                    event.getParentesco()));
        });

        apply((SaldoDeudaActualizada event) -> {
            cliente.cuenta.actualizarSaldoDeuda(event.getSaldoDeuda());
        });

        apply((CupoCuentaActualizado event) -> {
            cliente.cuenta.actualizarCupo(event.getCupo());
        });

        apply((ParentescoDeUnaReferenciaActualizado event) -> {
            var referencia = cliente.obtenerReferenciaPorId(event.getReferenciaId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra la referencia del cliente"));

            referencia.actualizarParentesco(event.getParentesco());
        });

        apply((TelefonoDeUnaReferenciaActualizado event) -> {
            var referencia = cliente.obtenerReferenciaPorId(event.getReferenciaId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra la referencia del cliente"));

            referencia.actualizarTelefono(event.getTelefono());
        });

        apply((NombreDeUnaReferenciaActualizado event) -> {
            var referencia = cliente.obtenerReferenciaPorId(event.getReferenciaId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra la referencia del cliente"));

            referencia.actualizarNombre(event.getNombre());
        });

        apply((DireccionActualizada event) -> {
            cliente.direccion = event.getDireccion();
        });

        apply((EstadoClienteActualizado event) -> {
            cliente.estado = event.getEstado();
        });
    }
}
