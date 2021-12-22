package co.com.sofka.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;


public class SaldoDeuda implements ValueObject<Double> {

    private final Double value;

    public SaldoDeuda(Double value) {
        Objects.requireNonNull(value);
        if (value < 0)
            throw new IllegalArgumentException("El valor del saldoDeuda no puede ser menor a cero");

        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaldoDeuda that = (SaldoDeuda) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public Double value() {
        return value;
    }

}
