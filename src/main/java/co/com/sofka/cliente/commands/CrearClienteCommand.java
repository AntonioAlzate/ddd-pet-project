package co.com.sofka.cliente.commands;

import co.com.sofka.cliente.values.ClienteId;
import co.com.sofka.cliente.values.Direccion;
import co.com.sofka.cliente.values.PersonaId;
import co.com.sofka.domain.generic.Command;

public class CrearClienteCommand extends Command {

    private final ClienteId clienteId;
    private final PersonaId personaId;
    private final Direccion direccion;

    public CrearClienteCommand(ClienteId clienteId, PersonaId personaId, Direccion direccion){

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
