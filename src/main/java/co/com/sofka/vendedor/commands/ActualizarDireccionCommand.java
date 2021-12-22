package co.com.sofka.vendedor.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generics.Direccion;
import co.com.sofka.vendedor.values.VendedorId;

public class ActualizarDireccionCommand extends Command {

    private final VendedorId vendedorId;
    private final Direccion direccion;

    public ActualizarDireccionCommand(VendedorId vendedorId, Direccion direccion){

        this.vendedorId = vendedorId;
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }
}
