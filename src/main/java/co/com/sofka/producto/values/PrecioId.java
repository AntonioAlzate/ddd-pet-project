package co.com.sofka.producto.values;

import co.com.sofka.domain.generic.Identity;

public class PrecioId extends Identity {

    public PrecioId() {

    }

    private PrecioId(String id) {
        super(id);
    }

    public static PrecioId of(String id) {
        return new PrecioId(id);
    }
}
