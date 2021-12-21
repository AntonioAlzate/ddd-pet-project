package co.com.sofka.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<String> {

    private final String numero;

    public Telefono(String numero) {
        Objects.requireNonNull(numero);
        if(numero.isBlank() || numero.length() < 6)
            throw new IllegalArgumentException("El número de telefono debe tener una longitud mayor a 6");
        if(numero.length() >= 25)
            throw new IllegalArgumentException("El número de telefono debe ser menor a 25 caracteres");

        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefono = (Telefono) o;
        return Objects.equals(numero, telefono.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String value() {
        return numero;
    }

}
