package co.com.sofka.producto.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.producto.Precio;
import co.com.sofka.producto.enums.Categoria;
import co.com.sofka.producto.values.BodegaId;
import co.com.sofka.producto.values.ProductoId;

public class CrearProductoCommand extends Command {

    private final ProductoId entityId;
    private final BodegaId bodegaId;
    private final Categoria categoria;
    private final Precio precio;

    public CrearProductoCommand(ProductoId entityId, BodegaId bodegaId, Categoria categoria, Precio precio){

        this.entityId = entityId;
        this.bodegaId = bodegaId;
        this.categoria = categoria;
        this.precio = precio;
    }

    public ProductoId getEntityId() {
        return entityId;
    }

    public BodegaId getBodegaId() {
        return bodegaId;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Precio getPrecio() {
        return precio;
    }
}
