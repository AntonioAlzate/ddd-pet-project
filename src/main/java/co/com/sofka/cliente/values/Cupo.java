package co.com.sofka.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cupo implements ValueObject<Double> {

    private final Double value;

    public Cupo(Double value) {
        Objects.requireNonNull(value);
        if (value < 0)
            throw new IllegalArgumentException("El valor del cupo no puede ser menor a cero");

        this.value = value;
    }

    @Override
    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cupo cupo = (Cupo) o;
        return Objects.equals(value, cupo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
