package co.com.sofka.producto.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.producto.Precio;
import co.com.sofka.producto.enums.Categoria;
import co.com.sofka.producto.values.*;

public class AgregarPrecioCommand extends Command {

    private final ProductoId productoId;
    private final PrecioId precioId;
    private final FechaVigencia fechaVigencia;
    private final Valor valor;

    public AgregarPrecioCommand(ProductoId productoId , PrecioId precioId, FechaVigencia fechaVigencia, Valor valor){

        this.productoId = productoId;
        this.precioId = precioId;
        this.fechaVigencia = fechaVigencia;
        this.valor = valor;
    }

    public ProductoId getProductoId() {
        return productoId;
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
