package co.com.sofka.vendedor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.vendedor.values.Anotacion;
import co.com.sofka.generics.Fecha;
import co.com.sofka.vendedor.values.RegistroDespachoId;

import java.util.Objects;

public class RegistroDespacho extends Entity<RegistroDespachoId> {

    private Fecha fecha;
    private Anotacion anotacion;

    public RegistroDespacho(RegistroDespachoId entityId) {
        super(entityId);
    }

    public void ponerAnotacion (Anotacion anotacion){
        this.anotacion = Objects.requireNonNull(anotacion);
    }

    public Anotacion anotacion() {
        return anotacion;
    }

    public Fecha fecha() {
        return fecha;
    }
}
