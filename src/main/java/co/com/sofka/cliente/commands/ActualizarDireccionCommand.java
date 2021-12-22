package co.com.sofka.cliente.commands;

import co.com.sofka.cliente.values.ClienteId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.Direccion;

public class ActualizarDireccionCommand extends Command {

    private final ClienteId clienteId;
    private final Direccion direccion;

    public ActualizarDireccionCommand(ClienteId clienteId, Direccion direccion) {

        this.clienteId = clienteId;
        this.direccion = direccion;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
