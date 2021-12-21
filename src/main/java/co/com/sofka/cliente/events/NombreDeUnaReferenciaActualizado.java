package co.com.sofka.cliente.events;

import co.com.sofka.cliente.values.Nombre;
import co.com.sofka.cliente.values.ReferenciaId;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreDeUnaReferenciaActualizado extends DomainEvent {
    private final ReferenciaId referenciaId;
    private final Nombre nombre;

    public NombreDeUnaReferenciaActualizado(ReferenciaId referenciaId, Nombre nombre) {
        super("sofka.cliente.nombrereferenciaactualizado");
        this.referenciaId = referenciaId;
        this.nombre = nombre;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
