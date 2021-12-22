package co.com.sofka.producto.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.producto.Precio;
import co.com.sofka.producto.enums.Categoria;
import co.com.sofka.producto.values.BodegaId;

public class ProductoCreado extends DomainEvent {

    private final Categoria categoria;
    private final Precio precio;
    private final BodegaId bodegaId;

    public ProductoCreado(Categoria categoria, Precio precio, BodegaId bodegaId) {
        super("sofka.producto.productocreado");
        this.categoria = categoria;
        this.precio = precio;
        this.bodegaId = bodegaId;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Precio getPrecio() {
        return precio;
    }

    public BodegaId getBodegaId() {
        return bodegaId;
    }
}
