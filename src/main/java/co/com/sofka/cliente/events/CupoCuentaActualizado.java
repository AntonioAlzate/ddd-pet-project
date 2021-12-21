package co.com.sofka.cliente.events;

import co.com.sofka.cliente.values.CuentaId;
import co.com.sofka.cliente.values.Cupo;
import co.com.sofka.domain.generic.DomainEvent;

public class CupoCuentaActualizado extends DomainEvent {

    private final Cupo cupo;

    public CupoCuentaActualizado(Cupo cupo) {
        super("sofka.cliente.cupocuentaactualizado");
        this.cupo = cupo;
    }

    public Cupo getCupo() {
        return cupo;
    }
}
