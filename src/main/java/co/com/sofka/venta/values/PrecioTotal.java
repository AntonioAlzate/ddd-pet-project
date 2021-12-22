package co.com.sofka.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PrecioTotal implements ValueObject<Double> {

    private final Double valor;

    public PrecioTotal(Double valor) {
        Objects.requireNonNull(valor);
        if (valor <= 0) {
            throw new IllegalArgumentException("el precio no puede ser menor o igual a cero");
        }
        this.valor = valor;
    }

    public PrecioTotal aplicarDescuento(Descuento descuento) {
        return new PrecioTotal(this.valor - this.valor * descuento.value().descuento());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrecioTotal that = (PrecioTotal) o;
        return Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public Double value() {
        return null;
    }
}
