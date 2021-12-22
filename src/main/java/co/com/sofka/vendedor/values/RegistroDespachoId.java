package co.com.sofka.vendedor.values;

import co.com.sofka.domain.generic.Identity;

public class RegistroDespachoId extends Identity {

    public RegistroDespachoId() {

    }

    private RegistroDespachoId(String id) {
        super(id);
    }

    public static RegistroDespachoId of(String id) {
        return new RegistroDespachoId(id);
    }
}
