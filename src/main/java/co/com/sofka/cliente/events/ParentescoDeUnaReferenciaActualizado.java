package co.com.sofka.cliente.events;

import co.com.sofka.cliente.enums.Parentesco;
import co.com.sofka.cliente.values.ReferenciaId;
import co.com.sofka.domain.generic.DomainEvent;

public class ParentescoDeUnaReferenciaActualizado extends DomainEvent {

    private final ReferenciaId referenciaId;
    private final Parentesco parentesco;

    public ParentescoDeUnaReferenciaActualizado(ReferenciaId referenciaId, Parentesco parentesco) {
        super("sofka.cliente.parentescoactualizado");
        this.referenciaId = referenciaId;
        this.parentesco = parentesco;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }
}
