package co.com.sofka.vendedor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.Estado;

public class EstadoVendedorActualizado extends DomainEvent {
    private final Estado estado;

    public EstadoVendedorActualizado(Estado estado) {
        super("sofka.vendedor.estadovendedoractualizado");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
