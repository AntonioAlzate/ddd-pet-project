package co.com.sofka.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.producto.values.ProductoId;
import co.com.sofka.venta.values.Cantidad;
import co.com.sofka.venta.values.DetalleVentaId;
import co.com.sofka.venta.values.PrecioTotal;
import co.com.sofka.venta.values.VentaId;

public class AgregarDetalleVentaCommand extends Command {

    private final VentaId ventaId;
    private final DetalleVentaId entityId;
    private final ProductoId productoId;
    private final Cantidad cantidad;
    private final PrecioTotal precioTotal;

    public AgregarDetalleVentaCommand(VentaId ventaId, DetalleVentaId entityId, ProductoId productoId, Cantidad cantidad, PrecioTotal precioTotal) {

        this.ventaId = ventaId;
        this.entityId = entityId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public VentaId getVentaId() {
        return ventaId;
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
