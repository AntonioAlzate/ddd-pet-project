package co.com.sofka.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.venta.values.CuotaInicial;
import co.com.sofka.venta.values.FormaPago;
import co.com.sofka.venta.values.PlanPagoId;
import co.com.sofka.venta.values.VentaId;

public class GenerarPlanDePagoCommand extends Command {

    private final PlanPagoId entityId;
    private final CuotaInicial cuotaInicial;
    private final Double valorTotal;
    private final FormaPago formaPago;
    private final VentaId ventaId;

    public GenerarPlanDePagoCommand(VentaId ventaId, PlanPagoId entityId, CuotaInicial cuotaInicial, Double valorTotal, FormaPago formaPago) {

        this.entityId = entityId;
        this.cuotaInicial = cuotaInicial;
        this.valorTotal = valorTotal;
        this.formaPago = formaPago;
        this.ventaId = ventaId;
    }

    public PlanPagoId getEntityId() {
        return entityId;
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

    public VentaId getVentaId() {
        return ventaId;
    }
}
