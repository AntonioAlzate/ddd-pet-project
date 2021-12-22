package co.com.sofka.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.producto.values.ProductoId;
import co.com.sofka.venta.values.Cantidad;
import co.com.sofka.venta.values.DetalleVentaId;
import co.com.sofka.venta.values.PrecioTotal;

public class DetalleVentaAgregado extends DomainEvent {
    private final DetalleVentaId entityId;
    private final ProductoId productoId;
    private final Cantidad cantidad;
    private final PrecioTotal precioTotal;

    public DetalleVentaAgregado(DetalleVentaId entityId, ProductoId productoId, Cantidad cantidad, PrecioTotal precioTotal) {
        super("sofka.venta.detalleventaagregado");
        this.entityId = entityId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public DetalleVentaId getEntityId() {
        return entityId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }

    public PrecioTotal getPrecioTotal() {
        return precioTotal;
    }
}
