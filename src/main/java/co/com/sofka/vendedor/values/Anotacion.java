package co.com.sofka.vendedor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Anotacion implements ValueObject<String> {

    private final String anotacion;

    public Anotacion(String anotaciones) {
        this.anotacion = Objects.requireNonNull(anotaciones);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anotacion anotacion1 = (Anotacion) o;
        return Objects.equals(anotacion, anotacion1.anotacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anotacion);
    }

    @Override
    public String value() {
        return anotacion;
    }
}
