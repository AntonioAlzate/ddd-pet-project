package co.com.sofka.venta.events;

import co.com.sofka.cliente.values.ClienteId;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.vendedor.values.VendedorId;
import co.com.sofka.venta.values.VentaId;

public class VentaCreada extends DomainEvent {
    private final ClienteId clienteId;
    private final VendedorId vendedorId;

    public VentaCreada(ClienteId clienteId, VendedorId vendedorId) {
        super("sofka.venta.ventacreada");
        this.clienteId = clienteId;
        this.vendedorId = vendedorId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }
}
