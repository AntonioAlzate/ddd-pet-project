package co.com.sofka.venta.values;

import co.com.sofka.domain.generic.Identity;

public class PlanPagoId extends Identity {

    public PlanPagoId() {

    }

    private PlanPagoId(String id) {
        super(id);
    }

    public static PlanPagoId of(String id) {
        return new PlanPagoId(id);
    }
}
