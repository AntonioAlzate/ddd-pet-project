package co.com.sofka.vendedor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.producto.values.ProductoId;
import co.com.sofka.vendedor.values.Anotacion;
import co.com.sofka.generics.Fecha;
import co.com.sofka.vendedor.values.RegistroDespachoId;

import java.util.Map;
import java.util.Objects;

public class RegistroDespacho extends Entity<RegistroDespachoId> {

    private Fecha fecha;
    private Map<ProductoId, Integer> productosLlevados;
    private Map<ProductoId, Integer> productosEntregar;
    private Anotacion anotacion;

    public RegistroDespacho(RegistroDespachoId entityId) {
        super(entityId);
    }

    public void ponerAnotacion (Anotacion anotacion){
        this.anotacion = Objects.requireNonNull(anotacion);
    }

    public void agregarProductoALlevar(ProductoId productoId, Integer cantidad){
        Objects.requireNonNull(productoId, "el id producto es necesario");
        Objects.requireNonNull(cantidad, "cantidad es requerido");
        if(cantidad <= 0)
            throw new IllegalArgumentException("La cantidad no puede ser menor o igual a cero");
        productosLlevados.put(productoId, cantidad);
    }

    public void quitarProductoALlevar(ProductoId productoId){
        Objects.requireNonNull(productoId, "el id producto es necesario");
        productosLlevados.remove(productoId);
    }

    public void agregarProductoAEntregar(ProductoId productoId, Integer cantidad){
        Objects.requireNonNull(productoId, "el id producto es necesario");
        Objects.requireNonNull(cantidad, "cantidad es requerido");
        if(cantidad <= 0)
            throw new IllegalArgumentException("La cantidad no puede ser menor o igual a cero");
        productosEntregar.put(productoId, cantidad);
    }

    public void quitarProductoAEntregar(ProductoId productoId){
        Objects.requireNonNull(productoId, "el id producto es necesario");
        productosEntregar.remove(productoId);
    }

    public Anotacion anotacion() {
        return anotacion;
    }

    public Map<ProductoId, Integer> getproductosEntregar() {
        return productosEntregar;
    }

    public Map<ProductoId, Integer> productosLlevados() {
        return productosLlevados;
    }

    public Fecha fecha() {
        return fecha;
    }
}
