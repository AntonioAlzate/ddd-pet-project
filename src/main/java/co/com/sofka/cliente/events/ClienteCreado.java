package co.com.sofka.cliente.events;

import co.com.sofka.cliente.values.Direccion;
import co.com.sofka.cliente.values.PersonaId;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteCreado extends DomainEvent {

    private final PersonaId personaId;
    private final Direccion direccion;

    public ClienteCreado(PersonaId personaId, Direccion direccion){
        super("sofka.cliente.clientecreado");
        this.personaId = personaId;
        this.direccion = direccion;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
