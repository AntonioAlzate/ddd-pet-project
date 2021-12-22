package co.com.sofka.vendedor.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.Estado;
import co.com.sofka.vendedor.values.VendedorId;

public class CambiarEstadoCommand extends Command {

    private final VendedorId vendedorId;
    private final Estado estado;

    public CambiarEstadoCommand(VendedorId vendedorId, Estado estado){

        this.vendedorId = vendedorId;
        this.estado = estado;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }

    public Estado getEstado() {
        return estado;
    }
}
