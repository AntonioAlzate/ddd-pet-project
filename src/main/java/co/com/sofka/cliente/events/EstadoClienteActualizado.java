package co.com.sofka.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.Estado;

public class EstadoClienteActualizado extends DomainEvent {

    private final Estado estado;

    public EstadoClienteActualizado(Estado estado) {
        super("sofka.cliente.estadoactualizado");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
