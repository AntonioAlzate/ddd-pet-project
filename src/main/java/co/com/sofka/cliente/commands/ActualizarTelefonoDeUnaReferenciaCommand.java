package co.com.sofka.cliente.commands;

import co.com.sofka.cliente.values.ClienteId;
import co.com.sofka.cliente.values.ReferenciaId;
import co.com.sofka.cliente.values.Telefono;
import co.com.sofka.domain.generic.Command;

public class ActualizarTelefonoDeUnaReferenciaCommand extends Command {

    private final ClienteId clienteId;
    private final ReferenciaId referenciaId;
    private final Telefono telefono;

    public ActualizarTelefonoDeUnaReferenciaCommand(ClienteId clienteId, ReferenciaId referenciaId, Telefono telefono) {

        this.clienteId = clienteId;
        this.referenciaId = referenciaId;
        this.telefono = telefono;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
