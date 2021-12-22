package co.com.sofka.venta;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.producto.values.ProductoId;
import co.com.sofka.venta.values.Cantidad;
import co.com.sofka.venta.values.Descuento;
import co.com.sofka.venta.values.DetalleVentaId;
import co.com.sofka.venta.values.PrecioTotal;

import java.util.Objects;

public class DetalleVenta extends Entity<DetalleVentaId> {

    private final ProductoId productoId;
    private Cantidad cantidad;
    private PrecioTotal precioTotal;


    public DetalleVenta(DetalleVentaId entityId, ProductoId productoId, Cantidad cantidad, PrecioTotal precioTotal) {
        super(entityId);
        this.productoId = Objects.requireNonNull(productoId);
        this.cantidad = Objects.requireNonNull(cantidad);
        this.precioTotal = Objects.requireNonNull(precioTotal);
    }

    public void agregarCantidad(Cantidad cantidad){
        this.cantidad = Objects.requireNonNull(cantidad);
    }

    public void aplicarDescuento(Descuento descuento){
        Objects.requireNonNull(descuento);
        this.precioTotal = this.precioTotal.aplicarDescuento(descuento);
    }

    public ProductoId productoId() {
        return productoId;
    }

    public Cantidad cantidad() {
        return cantidad;
    }

    public PrecioTotal precioTotal() {
        return precioTotal;
    }
}
