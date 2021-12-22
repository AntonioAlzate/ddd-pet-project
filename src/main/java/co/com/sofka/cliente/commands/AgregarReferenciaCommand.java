package co.com.sofka.cliente.commands;

import co.com.sofka.cliente.enums.Parentesco;
import co.com.sofka.cliente.values.ClienteId;
import co.com.sofka.cliente.values.Nombre;
import co.com.sofka.cliente.values.ReferenciaId;
import co.com.sofka.cliente.values.Telefono;
import co.com.sofka.domain.generic.Command;

public class AgregarReferenciaCommand extends Command {

    private final ClienteId clienteId;
    private final ReferenciaId entityId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Parentesco parentesco;

    public AgregarReferenciaCommand(ClienteId clienteId, ReferenciaId entityId, Nombre nombre, Telefono telefono, Parentesco parentesco) {

        this.clienteId = clienteId;
        this.entityId = entityId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.parentesco = parentesco;
    }

    public ClienteId getClienteId() {
        return clienteId;
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
