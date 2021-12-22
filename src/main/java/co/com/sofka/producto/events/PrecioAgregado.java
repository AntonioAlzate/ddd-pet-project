package co.com.sofka.producto.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.producto.Precio;
import co.com.sofka.producto.values.FechaVigencia;
import co.com.sofka.producto.values.PrecioId;
import co.com.sofka.producto.values.Valor;

public class PrecioAgregado extends DomainEvent {


    private final PrecioId precioId;
    private final FechaVigencia fechaVigencia;
    private final Valor valor;

    public PrecioAgregado(PrecioId precioId, FechaVigencia fechaVigencia, Valor valor) {
        super("sofka.producto.precioagregado");

        this.precioId = precioId;
        this.fechaVigencia = fechaVigencia;
        this.valor = valor;
    }

    public PrecioId getPrecioId() {
        return precioId;
    }

    public FechaVigencia getFechaVigencia() {
        return fechaVigencia;
    }

    public Valor getValor() {
        return valor;
    }
}
