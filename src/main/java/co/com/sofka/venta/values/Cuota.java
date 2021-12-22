package co.com.sofka.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class Cuota implements ValueObject<Cuota.Properties> {

    private final CuotaId cuota;
    private final Double valor;
    private final LocalDate fechaPropuesta;
    private final LocalDate fechaRealizacion;

    public Cuota(CuotaId cuota, Double valor, LocalDate fechaPropuesta, LocalDate fechaRealizacion) {
        this.cuota = Objects.requireNonNull(cuota);
        this.valor = Objects.requireNonNull(valor);
        this.fechaPropuesta = Objects.requireNonNull(fechaPropuesta);
        this.fechaRealizacion = fechaRealizacion;
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public CuotaId cuotaId() {
                return null;
            }

            @Override
            public Double valor() {
                return null;
            }

            @Override
            public LocalDate fechaPropuesta() {
                return null;
            }

            @Override
            public LocalDate fechaRealizacion() {
                return null;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuota cuota1 = (Cuota) o;
        return Objects.equals(cuota, cuota1.cuota) && Objects.equals(valor, cuota1.valor) && Objects.equals(fechaPropuesta, cuota1.fechaPropuesta) && Objects.equals(fechaRealizacion, cuota1.fechaRealizacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuota, valor, fechaPropuesta, fechaRealizacion);
    }

    public interface Properties {
        CuotaId cuotaId();
        Double valor();
        LocalDate fechaPropuesta();
        LocalDate fechaRealizacion();
    }
}