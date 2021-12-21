package co.com.sofka.cliente.commands;

import co.com.sofka.cliente.enums.Parentesco;
import co.com.sofka.cliente.values.ClienteId;
import co.com.sofka.cliente.values.ReferenciaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarParentezcoDeUnaReferenciaCommand extends Command {

    private final ClienteId clienteId;
    private final ReferenciaId referenciaId;
    private final Parentesco parentesco;

    public ActualizarParentezcoDeUnaReferenciaCommand(ClienteId clienteId, ReferenciaId referenciaId, Parentesco parentesco){

        this.clienteId = clienteId;
        this.referenciaId = referenciaId;
        this.parentesco = parentesco;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }
}
