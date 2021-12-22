package co.com.sofka.cliente.events;

import co.com.sofka.cliente.values.SaldoDeuda;
import co.com.sofka.domain.generic.DomainEvent;

public class SaldoDeudaActualizada extends DomainEvent {

    private final SaldoDeuda saldoDeuda;

    public SaldoDeudaActualizada(SaldoDeuda saldoDeuda) {
        super("sofka.cliente.saldodeudaactualizada");

        this.saldoDeuda = saldoDeuda;
    }

    public SaldoDeuda getSaldoDeuda() {
        return saldoDeuda;
    }
}
