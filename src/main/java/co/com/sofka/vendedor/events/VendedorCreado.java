package co.com.sofka.vendedor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.Direccion;
import co.com.sofka.generics.PersonaId;
import co.com.sofka.vendedor.RegistroDespacho;
import co.com.sofka.vendedor.values.VendedorId;

public class VendedorCreado extends DomainEvent {
    private final VendedorId entityId;
    private final PersonaId personaId;
    private final RegistroDespacho registroDespacho;
    private final Direccion direccion;

    public VendedorCreado(VendedorId entityId, PersonaId personaId, RegistroDespacho registroDespacho, Direccion direccion) {
        super("sofka.vendedor.vendedorcreado");
        this.entityId = entityId;
        this.personaId = personaId;
        this.registroDespacho = registroDespacho;
        this.direccion = direccion;
    }

    public VendedorId getEntityId() {
        return entityId;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public RegistroDespacho getRegistroDespacho() {
        return registroDespacho;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
