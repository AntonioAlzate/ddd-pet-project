package co.com.sofka.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<Nombre.Properties> {

    private final String nombres;
    private final String apellidos;

    public Nombre(String nombres, String apellidos) {
        this.nombres = Objects.requireNonNull(nombres);
        this.apellidos = Objects.requireNonNull(apellidos);
        if (this.nombres.isBlank()) {
            throw new IllegalArgumentException("El valor nombres no puede ser vacío");
        }
        if (this.nombres.length() <= 5) {
            throw new IllegalArgumentException("El valor nombres debe tener mas de 5 caracteres");
        }
        if (this.nombres.length() >= 100) {
            throw new IllegalArgumentException("El valor nombres debe ser menor a 100 caracteres");
        }
        if (this.apellidos.isBlank()) {
            throw new IllegalArgumentException("El valor apellidos no puede ser vacío");
        }
        if (this.apellidos.length() <= 5) {
            throw new IllegalArgumentException("El valor apellidos debe tener mas de 5 caracteres");
        }
        if (this.apellidos.length() >= 100) {
            throw new IllegalArgumentException("El valor apellidos debe ser menor a 100 caracteres");
        }
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public String nombre() {
                return nombres;
            }

            @Override
            public String apellidos() {
                return apellidos;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombre nombre = (Nombre) o;
        return Objects.equals(nombres, nombre.nombres) && Objects.equals(apellidos, nombre.apellidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombres, apellidos);
    }

    public interface Properties {
        String nombre();

        String apellidos();
    }
}
