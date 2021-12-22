package co.com.sofka.venta;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.generics.Fecha;
import co.com.sofka.venta.events.DetalleVentaAgregado;
import co.com.sofka.venta.events.PlanPagoGenerado;
import co.com.sofka.venta.events.VentaCreada;

import java.time.LocalDate;
import java.util.HashSet;

public class VentaChange extends EventChange {
    public VentaChange(Venta venta) {

        apply((VentaCreada event) -> {
            venta.clienteId = event.getClienteId();
            venta.vendedorId = event.getVendedorId();
            venta.fecha = new Fecha(LocalDate.now());
            venta.detallesVenta = new HashSet<>();

        });

        apply((DetalleVentaAgregado event) -> {
            venta.detallesVenta.add(new DetalleVenta(
                    event.getEntityId(),
                    event.getProductoId(),
                    event.getCantidad(),
                    event.getPrecioTotal()
            ));
        });

        apply((PlanPagoGenerado event) -> {
            venta.planPago = new PlanPago(
                    event.getPlanPagoId(),
                    event.getFormaPago(),
                    event.getCuotaInicial(),
                    event.getValorTotal());
        });
    }
}
