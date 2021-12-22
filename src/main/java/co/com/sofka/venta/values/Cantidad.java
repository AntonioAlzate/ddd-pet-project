package co.com.sofka.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cantidad implements ValueObject<Integer> {

    private final Integer valor;

    public Cantidad(Integer valor){
        Objects.requireNonNull(valor);
        if(valor <= 0)
            throw new IllegalArgumentException("la cantidad no puede ser menor o igual a cero");

        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cantidad cantidad = (Cantidad) o;
        return Objects.equals(valor, cantidad.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public Integer value() {
        return valor;
    }
}
