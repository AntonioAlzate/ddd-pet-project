package co.com.sofka.cliente.events;

import co.com.sofka.cliente.enums.Parentesco;
import co.com.sofka.cliente.values.Nombre;
import co.com.sofka.cliente.values.ReferenciaId;
import co.com.sofka.cliente.values.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class ReferenciaAgregada extends DomainEvent {

    private final ReferenciaId entityId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Parentesco parentesco;

    public ReferenciaAgregada(ReferenciaId entityId, Nombre nombre, Telefono telefono, Parentesco parentesco) {
        super("sofka.cliente.referenciaagregada");
        this.entityId = entityId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.parentesco = parentesco;
    }

    public ReferenciaId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }
}
