package co.com.sofka.producto;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.generics.Estado;
import co.com.sofka.producto.events.CategoriaProductoActualizada;
import co.com.sofka.producto.events.FechaVigenciaPrecioActualizada;
import co.com.sofka.producto.events.PrecioAgregado;
import co.com.sofka.producto.events.ProductoCreado;
import co.com.sofka.producto.values.FechaVigencia;
import co.com.sofka.producto.values.Valor;

import java.util.Set;
import java.util.stream.Collectors;

public class ProductoChange extends EventChange {
    public ProductoChange(Producto producto) {

        apply((ProductoCreado event) -> {
            producto.bodegaId = event.getBodegaId();
            producto.categoria = event.getCategoria();
            producto.precios = Set.of(event.getPrecio());
        });

        apply((CategoriaProductoActualizada event) -> {
            producto.categoria = event.getCategoria();
        });

        apply((PrecioAgregado event) -> {
            FechaVigencia fechaVigencia = event.getFechaVigencia();
            Valor valor = event.getValor();

            int numero = producto.precios.stream()
                    .filter(precio -> {
                        return event.getFechaVigencia().value().fechaInicio().isAfter(precio.fechaVigencia.value().fechaInicio())
                                && event.getFechaVigencia().value().fechaInicio().isBefore(precio.fechaVigencia.value().fechaFin());
                    }).collect(Collectors.toList()).size();

            if (numero > 0) {
                throw new IllegalArgumentException("El precio no puede tener una fecha de inicio que este dentro " +
                        "de la vigencia de otro precio");
            }

            producto.precios.stream().map(precio -> precio.estado = Estado.INACTIVO);

            producto.precios.add(new Precio(
                    event.getPrecioId(),
                    event.getFechaVigencia(),
                    event.getValor()
            ));
        });

        apply((FechaVigenciaPrecioActualizada event) -> {
            var precioObtenido =
                    producto.obtenerPrecioPorId(event.getPrecioId())
                            .orElseThrow(() -> new IllegalArgumentException("El precio no existe"));

            if (precioObtenido.estado == Estado.INACTIVO) {
                throw new IllegalArgumentException("No es posible cambiar la fecha de un precio inactivo");
            }

            int numero = producto.precios.stream()
                    .filter(precio -> {
                        return event.getFechaVigencia().value().fechaInicio().isAfter(precio.fechaVigencia.value().fechaInicio())
                                && event.getFechaVigencia().value().fechaInicio().isBefore(precio.fechaVigencia.value().fechaFin());
                    }).collect(Collectors.toList()).size();

            if (numero > 0) {
                throw new IllegalArgumentException("El precio no puede tener una fecha de inicio que este dentro " +
                        "de la vigencia de otro precio");
            }

            precioObtenido.cambiarFechaVigencia(event.getFechaVigencia());
        });
    }
}
