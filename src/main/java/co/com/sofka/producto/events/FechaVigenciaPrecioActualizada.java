package co.com.sofka.producto.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.producto.values.FechaVigencia;
import co.com.sofka.producto.values.PrecioId;
import co.com.sofka.producto.values.ProductoId;

public class FechaVigenciaPrecioActualizada extends DomainEvent {
    private final PrecioId precioId;
    private final FechaVigencia fechaVigencia;

    public FechaVigenciaPrecioActualizada(PrecioId precioId, FechaVigencia fechaVigencia) {
        super("sofka.producto.fechavigenciaprecioactualizada");
        this.precioId = precioId;
        this.fechaVigencia = fechaVigencia;
    }

    public PrecioId getPrecioId() {
        return precioId;
    }

    public FechaVigencia getFechaVigencia() {
        return fechaVigencia;
    }
}
