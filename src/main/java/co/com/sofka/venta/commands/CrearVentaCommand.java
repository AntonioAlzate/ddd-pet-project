package co.com.sofka.venta.commands;

import co.com.sofka.cliente.values.ClienteId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.vendedor.values.VendedorId;
import co.com.sofka.venta.values.VentaId;

public class CrearVentaCommand extends Command {

    private final VentaId entityId;
    private final ClienteId clienteId;
    private final VendedorId vendedorId;

    public CrearVentaCommand(VentaId entityId, ClienteId clienteId, VendedorId vendedorId) {

        this.entityId = entityId;
        this.clienteId = clienteId;
        this.vendedorId = vendedorId;
    }

    public VentaId getEntityId() {
        return entityId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }
}
