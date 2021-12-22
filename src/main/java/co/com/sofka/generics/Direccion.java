package co.com.sofka.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Direccion implements ValueObject<Direccion.Properties> {

    private final String caracteristica;
    private final String direccion;

    public Direccion(String direccion, String caracteristica) {
        this.direccion = Objects.requireNonNull(direccion, "la dirección es requerida");
        this.caracteristica = Objects.requireNonNull(caracteristica, "la caracteristica es requerida");

        if (direccion.isBlank()) {
            throw new IllegalArgumentException("la dirección no puede estás vacia");
        }
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public String direccion() {
                return direccion;
            }

            @Override
            public String caracteristica() {
                return caracteristica;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direccion direccion1 = (Direccion) o;
        return Objects.equals(caracteristica, direccion1.caracteristica) && Objects.equals(direccion, direccion1.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caracteristica, direccion);
    }

    public interface Properties {
        String direccion();

        String caracteristica();
    }
}
