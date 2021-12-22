package co.com.sofka.venta.values;

import co.com.sofka.domain.generic.Identity;

public class DetalleVentaId extends Identity {

    public DetalleVentaId(){

    }

    private DetalleVentaId(String id){
        super(id);
    }

    public static DetalleVentaId of(String id){
        return new DetalleVentaId(id);
    }
}
