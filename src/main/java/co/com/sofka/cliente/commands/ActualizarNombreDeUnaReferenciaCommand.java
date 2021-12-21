package co.com.sofka.cliente.commands;

import co.com.sofka.cliente.values.ClienteId;
import co.com.sofka.cliente.values.Nombre;
import co.com.sofka.cliente.values.ReferenciaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreDeUnaReferenciaCommand extends Command {

    private final ClienteId clienteId;
    private final ReferenciaId referenciaId;
    private final Nombre nombre;

    public ActualizarNombreDeUnaReferenciaCommand(ClienteId clienteId, ReferenciaId referenciaId, Nombre nombre){

        this.clienteId = clienteId;
        this.referenciaId = referenciaId;
        this.nombre = nombre;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
