package co.com.sofka.venta.values;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.venta.enums.Modalidad;
import co.com.sofka.venta.enums.Periodicidad;

import java.util.Objects;

public class FormaPago implements ValueObject<FormaPago.Propeties> {

    private final Modalidad modalidad;
    private final Periodicidad periodicidad;

    public FormaPago(Modalidad modalidad, Periodicidad periodicidad){
        this.modalidad = Objects.requireNonNull(modalidad);
        this.periodicidad = Objects.requireNonNull(periodicidad);
    }

    @Override
    public Propeties value() {
        return new Propeties() {
            @Override
            public Modalidad modalidad() {
                return modalidad;
            }

            @Override
            public Periodicidad periodicidad() {
                return periodicidad;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormaPago formaPago = (FormaPago) o;
        return modalidad == formaPago.modalidad && periodicidad == formaPago.periodicidad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(modalidad, periodicidad);
    }

    public interface Propeties {
        Modalidad modalidad();
        Periodicidad periodicidad();
    }
}
