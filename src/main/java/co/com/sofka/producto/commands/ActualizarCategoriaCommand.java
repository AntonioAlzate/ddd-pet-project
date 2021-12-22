package co.com.sofka.producto.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.producto.enums.Categoria;
import co.com.sofka.producto.values.ProductoId;

public class ActualizarCategoriaCommand extends Command {

    private final ProductoId productoId;
    private final Categoria categoria;

    public ActualizarCategoriaCommand(ProductoId productoId, Categoria categoria){

        this.productoId = productoId;
        this.categoria = categoria;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
