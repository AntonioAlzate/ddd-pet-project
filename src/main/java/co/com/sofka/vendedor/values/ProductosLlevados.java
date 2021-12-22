package co.com.sofka.vendedor.values;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.producto.values.ProductoId;

import java.util.Map;

public class ProductosLlevados implements ValueObject<Map<ProductoId, Integer>> {

    Map<ProductoId, Integer> productosLlevados;

    @Override
    public Map<ProductoId, Integer> value() {
        return null;
    }

}
