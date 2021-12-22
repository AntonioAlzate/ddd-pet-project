package co.com.sofka.producto;

import co.com.sofka.generics.Estado;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.producto.values.FechaVigencia;
import co.com.sofka.producto.values.PrecioId;
import co.com.sofka.producto.values.Valor;

import java.util.Objects;

public class Precio extends Entity<PrecioId> {

    protected FechaVigencia fechaVigencia;
    protected Valor valor;
    protected Estado estado;

    public Precio(PrecioId entityId, FechaVigencia fechaVigencia, Valor valor) {
        super(entityId);
        this.fechaVigencia = Objects.requireNonNull(fechaVigencia, "La fecha de vigencia no puede ser null");
        this.valor = Objects.requireNonNull(valor, "El valor no puede ser null");
        this.estado = Estado.ACTIVO;
    }

    public void cambiarEstadoPrecio(Estado estado){
        this.estado = Objects.requireNonNull(estado, "el estado es requerido");
    }

    public void cambiarFechaVigencia(FechaVigencia fechaVigencia){
        Objects.requireNonNull(fechaVigencia);
        if(this.fechaVigencia == fechaVigencia){
            throw new IllegalArgumentException("La fecha que intenta poner es la misma que se encuentra actualmente");
        }
        if(fechaVigencia.value().fechaInicio().isAfter(fechaVigencia.value().fechaFin())){
            throw new IllegalArgumentException("La fecha de inicio no puede ser mayor a la fecha de fin");
        }

        this.fechaVigencia = fechaVigencia;
    }

    public FechaVigencia fechaVigencia() {
        return fechaVigencia;
    }

    public Valor valor() {
        return valor;
    }

    public Estado estado() {
        return estado;
    }
}
