package co.com.sofka.cliente.commands;

import co.com.sofka.cliente.values.ClienteId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.Direccion;
import co.com.sofka.generics.PersonaId;

public class CrearClienteCommand extends Command {

    private final ClienteId clienteId;
    private final PersonaId personaId;
    private final Direccion direccion;

    public CrearClienteCommand(ClienteId clienteId, PersonaId personaId, Direccion direccion) {

        this.clienteId = clienteId;
        this.personaId = personaId;
        this.direccion = direccion;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
