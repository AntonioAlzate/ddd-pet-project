package co.com.sofka.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.venta.values.CuotaInicial;
import co.com.sofka.venta.values.FormaPago;
import co.com.sofka.venta.values.PlanPagoId;

public class PlanPagoGenerado extends DomainEvent {
    private final CuotaInicial cuotaInicial;
    private final Double valorTotal;
    private final FormaPago formaPago;
    private final PlanPagoId planPagoId;

    public PlanPagoGenerado(PlanPagoId planPagoId, CuotaInicial cuotaInicial, Double valorTotal, FormaPago formaPago) {
        super("sofka.venta.cuotasgeneradas");
        this.cuotaInicial = cuotaInicial;
        this.valorTotal = valorTotal;
        this.formaPago = formaPago;
        this.planPagoId = planPagoId;
    }

    public CuotaInicial getCuotaInicial() {
        return cuotaInicial;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public PlanPagoId getPlanPagoId() {
        return planPagoId;
    }
}
