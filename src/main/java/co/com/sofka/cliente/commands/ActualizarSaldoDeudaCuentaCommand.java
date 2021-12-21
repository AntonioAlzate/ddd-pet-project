package co.com.sofka.cliente.commands;

import co.com.sofka.cliente.values.ClienteId;
import co.com.sofka.cliente.values.SaldoDeuda;
import co.com.sofka.domain.generic.Command;

public class ActualizarSaldoDeudaCuentaCommand extends Command {

    private final ClienteId clienteId;
    private final SaldoDeuda saldoDeuda;

    public ActualizarSaldoDeudaCuentaCommand(ClienteId clienteId, SaldoDeuda saldoDeuda){

        this.clienteId = clienteId;
        this.saldoDeuda = saldoDeuda;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public SaldoDeuda getSaldoDeuda() {
        return saldoDeuda;
    }
}
