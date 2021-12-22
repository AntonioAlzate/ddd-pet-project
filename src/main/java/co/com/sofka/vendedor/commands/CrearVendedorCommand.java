package co.com.sofka.vendedor.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.Direccion;
import co.com.sofka.generics.PersonaId;
import co.com.sofka.vendedor.RegistroDespacho;
import co.com.sofka.vendedor.values.VendedorId;

public class CrearVendedorCommand extends Command {

    private final VendedorId entityId;
    private final PersonaId personaId;
    private final RegistroDespacho registroDespacho;
    private final Direccion direccion;

    public CrearVendedorCommand(VendedorId entityId, PersonaId personaId, RegistroDespacho registroDespacho, Direccion direccion){

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
