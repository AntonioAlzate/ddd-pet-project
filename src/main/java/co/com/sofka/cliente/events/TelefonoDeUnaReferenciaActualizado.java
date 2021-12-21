package co.com.sofka.cliente.events;

import co.com.sofka.cliente.values.ReferenciaId;
import co.com.sofka.cliente.values.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class TelefonoDeUnaReferenciaActualizado extends DomainEvent {
    private final ReferenciaId referenciaId;
    private final Telefono telefono;

    public TelefonoDeUnaReferenciaActualizado(ReferenciaId referenciaId, Telefono telefono) {
        super("sofka.cliente.telefonoreferenciaactualizado");
        this.referenciaId = referenciaId;
        this.telefono = telefono;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
