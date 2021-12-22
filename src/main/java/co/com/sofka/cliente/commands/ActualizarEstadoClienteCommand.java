package co.com.sofka.cliente.commands;

import co.com.sofka.cliente.values.ClienteId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.Estado;

public class ActualizarEstadoClienteCommand extends Command {

    private final ClienteId clienteId;
    private final Estado estado;

    public ActualizarEstadoClienteCommand(ClienteId clienteId, Estado estado) {

        this.clienteId = clienteId;
        this.estado = estado;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Estado getEstado() {
        return estado;
    }
}
