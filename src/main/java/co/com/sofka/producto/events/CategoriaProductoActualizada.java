package co.com.sofka.producto.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.producto.enums.Categoria;

public class CategoriaProductoActualizada extends DomainEvent {

    private final Categoria categoria;

    public CategoriaProductoActualizada(Categoria categoria) {
        super("sofka.producto.categoriaactualizada");
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
