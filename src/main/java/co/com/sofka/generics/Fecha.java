package co.com.sofka.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class Fecha implements ValueObject<LocalDate> {

    private final LocalDate fecha;

    public Fecha(LocalDate fecha){
        Objects.requireNonNull(fecha, "La fecha es requerida");
        if(fecha.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("No se puede crear un despacho con una fecha del pasado");
        }

        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fecha fecha1 = (Fecha) o;
        return Objects.equals(fecha, fecha1.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha);
    }

    @Override
    public LocalDate value() {
        return null;
    }
}
