package co.com.sofka.vendedor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.Direccion;

public class DireccionVendedorActualizada extends DomainEvent {

    private final Direccion direccion;

    public DireccionVendedorActualizada(Direccion direccion) {
        super("sofka.vendedor.direccionactualizada");
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
