package co.com.sofka.venta;

import co.com.sofka.cliente.values.ClienteId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.Fecha;
import co.com.sofka.producto.values.ProductoId;
import co.com.sofka.vendedor.values.VendedorId;
import co.com.sofka.venta.events.DetalleVentaAgregado;
import co.com.sofka.venta.events.PlanPagoGenerado;
import co.com.sofka.venta.events.VentaCreada;
import co.com.sofka.venta.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Venta extends AggregateEvent<VentaId> {

    protected Set<DetalleVenta> detallesVenta;
    protected PlanPago planPago;
    protected ClienteId clienteId;
    protected VendedorId vendedorId;
    protected Fecha fecha;
    protected Descuento descuento;

    public Venta(VentaId entityId, ClienteId clienteId, VendedorId vendedorId) {
        super(entityId);
        Objects.requireNonNull(clienteId, "el id cliente es requerido");
        Objects.requireNonNull(vendedorId, "vendedor id es requerido");
        appendChange(new VentaCreada(clienteId, vendedorId)).apply();
    }

    private Venta(VentaId ventaId) {
        super(ventaId);
        subscribe(new VentaChange(this));
    }

    public static Venta from(VentaId ventaId, List<DomainEvent> events) {
        var venta = new Venta(ventaId);
        events.forEach(venta::applyEvent);
        return venta;
    }

    public void agregarDetalleVenta(DetalleVentaId entityId, ProductoId productoId, Cantidad cantidad, PrecioTotal precioTotal) {
        Objects.requireNonNull(entityId, "detalle de venta id es requerido");
        Objects.requireNonNull(productoId, "el producto id es requerido");
        Objects.requireNonNull(cantidad, "la cantidad es requerida");
        Objects.requireNonNull(precioTotal, "el precio total es requerido");

        appendChange(new DetalleVentaAgregado(entityId, productoId, cantidad, precioTotal)).apply();
    }

    public void generarPlanPago(PlanPagoId entityId, CuotaInicial cuotaInicial, Double valorTotal, FormaPago formaPago) {
        Objects.requireNonNull(cuotaInicial, "cuota inicial requerida");
        Objects.requireNonNull(valorTotal, "valor total requerido");
        Objects.requireNonNull(formaPago, "la forma de pago es requerida");

        appendChange(new PlanPagoGenerado(entityId, cuotaInicial, valorTotal, formaPago)).apply();
    }

    public Set<DetalleVenta> detallesVenta() {
        return detallesVenta;
    }

    public PlanPago planPago() {
        return planPago;
    }

    public ClienteId clienteId() {
        return clienteId;
    }

    public VendedorId vendedorId() {
        return vendedorId;
    }

    public Fecha fecha() {
        return fecha;
    }

    public Descuento descuento() {
        return descuento;
    }
}
