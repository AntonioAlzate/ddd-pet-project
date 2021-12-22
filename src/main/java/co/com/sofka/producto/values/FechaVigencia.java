package co.com.sofka.producto.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class FechaVigencia implements ValueObject<FechaVigencia.Properties> {

    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;

    public FechaVigencia(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = Objects.requireNonNull(fechaInicio);
        this.fechaFin = Objects.requireNonNull(fechaFin);

        if(fechaInicio.isAfter(fechaFin)){
            throw new IllegalArgumentException("La fecha de inicio no puede estar despues que la de fin");
        }
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public LocalDate fechaInicio() {
                return fechaInicio;
            }

            @Override
            public LocalDate fechaFin() {
                return fechaFin;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaVigencia that = (FechaVigencia) o;
        return Objects.equals(fechaInicio, that.fechaInicio) && Objects.equals(fechaFin, that.fechaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaInicio, fechaFin);
    }

    public interface Properties{
        LocalDate fechaInicio();
        LocalDate fechaFin();
    }
}
