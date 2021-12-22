package co.com.sofka.venta.values;

import co.com.sofka.domain.generic.Identity;

public class CuotaId extends Identity {
    public CuotaId(){

    }

    private CuotaId(String id){
        super(id);
    }

    public static CuotaId of(String id){
        return new CuotaId(id);
    }
}
