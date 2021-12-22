package co.com.sofka.producto;

import co.com.sofka.cliente.Referencia;
import co.com.sofka.cliente.values.ReferenciaId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.producto.enums.Categoria;
import co.com.sofka.producto.events.CategoriaProductoActualizada;
import co.com.sofka.producto.events.FechaVigenciaPrecioActualizada;
import co.com.sofka.producto.events.PrecioAgregado;
import co.com.sofka.producto.events.ProductoCreado;
import co.com.sofka.producto.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Producto extends AggregateEvent<ProductoId> {

    protected BodegaId bodegaId;
    protected Categoria categoria;
    protected Set<Precio> precios;

    public Producto(ProductoId entityId, BodegaId bodegaId, Categoria categoria, Precio precio) {
        super(entityId);
        Objects.requireNonNull(categoria, "La categoria es requerida");
        Objects.requireNonNull(precio, "Se debe establecer el precio inicial");

        appendChange(new ProductoCreado(categoria,precio, bodegaId)).apply();
    }

    private Producto(ProductoId productoId){
        super(productoId);
        subscribe(new ProductoChange(this));
    }

    public static Producto from(ProductoId productoId, List<DomainEvent> event){
        var producto = new Producto(productoId);
        event.forEach(producto::applyEvent);
        return producto;
    }

    public void actualizarCategoria(Categoria categoria){
        this.categoria = Objects.requireNonNull(categoria, "la categoría es requerida");

        appendChange(new CategoriaProductoActualizada(categoria));
    }

    public void agregarPrecio(PrecioId precioId, FechaVigencia fechaVigencia, Valor valor){
        Objects.requireNonNull(precioId, "el precio es requerido");
        Objects.requireNonNull(fechaVigencia, "la fecha de vigencia es requerida");
        Objects.requireNonNull(valor, "el valor es requerido");

        appendChange(new PrecioAgregado(precioId, fechaVigencia, valor)).apply();
    }

    public void ActualizarFechaVigenciaDeUnPrecio(PrecioId precioId, FechaVigencia fechaVigencia){
        Objects.requireNonNull(precioId, "el producto id es requerido");
        Objects.requireNonNull(fechaVigencia, "la fecha de vigencia es requerida");

        appendChange(new FechaVigenciaPrecioActualizada(precioId, fechaVigencia)).apply();
    }

    protected Optional<Precio> obtenerPrecioPorId(PrecioId precioId){
        return precios
                .stream()
                .filter(precio -> precio.identity().equals(precioId))
                .findFirst();
    }

    public BodegaId bodegaId() {
        return bodegaId;
    }

    public Categoria categoria() {
        return categoria;
    }

    public Set<Precio> precio() {
        return precios;
    }
}
