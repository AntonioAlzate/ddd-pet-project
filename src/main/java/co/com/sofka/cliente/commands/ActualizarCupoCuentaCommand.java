package co.com.sofka.cliente.commands;

import co.com.sofka.cliente.values.ClienteId;
import co.com.sofka.cliente.values.Cupo;
import co.com.sofka.domain.generic.Command;

public class ActualizarCupoCuentaCommand extends Command {

    private final ClienteId clienteId;
    private final Cupo cupo;

    public ActualizarCupoCuentaCommand(ClienteId clienteId, Cupo cupo){

        this.clienteId = clienteId;
        this.cupo = cupo;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Cupo getCupo() {
        return cupo;
    }
}
