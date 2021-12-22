package co.com.sofka.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CuotaInicial implements ValueObject<CuotaInicial.Properties> {

    private final Double valor;
    private final String detalle;

    public CuotaInicial(Double valor, String detalle) {
        if(valor <0){
            throw new IllegalArgumentException("El valor no puede ser menor a cero");
        }
        this.valor = Objects.requireNonNull(valor);
        this.detalle = Objects.requireNonNull(detalle);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public Double valor() {
                return null;
            }

            @Override
            public String detalle() {
                return null;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuotaInicial that = (CuotaInicial) o;
        return Objects.equals(valor, that.valor) && Objects.equals(detalle, that.detalle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, detalle);
    }

    public interface Properties{
        Double valor();
        String detalle();
    }
}
