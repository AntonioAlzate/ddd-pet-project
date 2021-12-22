package co.com.sofka.vendedor;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.generics.Estado;
import co.com.sofka.vendedor.events.DireccionVendedorActualizada;
import co.com.sofka.vendedor.events.EstadoVendedorActualizado;
import co.com.sofka.vendedor.events.VendedorCreado;

public class VendedorChange extends EventChange {
    public VendedorChange(Vendedor vendedor) {

        apply((VendedorCreado event) -> {
            vendedor.personaId = event.getPersonaId();
            vendedor.direccion = event.getDireccion();
            vendedor.estado = Estado.ACTIVO;
            vendedor.registroDespacho = event.getRegistroDespacho();
        });

        apply((EstadoVendedorActualizado event) -> {
            if (vendedor.estado.equals(event.getEstado())) {
                throw new IllegalArgumentException("El estado que intentas asignar es igual al actual");
            }

            vendedor.estado = event.getEstado();
        });

        apply((DireccionVendedorActualizada event) -> {
            vendedor.direccion = event.getDireccion();
        });
    }
}
