package co.com.sofka.cliente.events;

import co.com.sofka.generics.Direccion;
import co.com.sofka.domain.generic.DomainEvent;

public class DireccionActualizada extends DomainEvent {

    private final Direccion direccion;

    public DireccionActualizada(Direccion direccion) {
        super("sofka.cliente.direccionactualizada");
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

}
