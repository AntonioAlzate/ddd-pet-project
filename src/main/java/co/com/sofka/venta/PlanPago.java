package co.com.sofka.venta;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generics.Fecha;
import co.com.sofka.venta.enums.Periodicidad;
import co.com.sofka.venta.values.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class PlanPago extends Entity<PlanPagoId> {

    private Fecha fechaInicial;
    private FormaPago formaPago;
    private Set<Cuota> cuotas;
    private CuotaInicial cuotaInicial;

    public PlanPago(PlanPagoId entityId, FormaPago formaPago, CuotaInicial cuotaInicial, Double valorTotal) {
        super(entityId);
        this.cuotaInicial = Objects.requireNonNull(cuotaInicial);
        this.formaPago = Objects.requireNonNull(formaPago);
        this.fechaInicial = new Fecha(LocalDate.now());
        generarCuotas(cuotaInicial, valorTotal, formaPago);
    }

    public void generarCuotas(CuotaInicial cuotaInicial, Double valorTotal, FormaPago formaPago) {
        Objects.requireNonNull(cuotaInicial);
        Objects.requireNonNull(valorTotal);

        var valor = valorTotal - cuotaInicial.value().valor();
        var periodicidad = formaPago.value().periodicidad();
        var fecha = fechaInicial.value();
        var valorSemana = 10000D;
        var valorQuincena = 15000D;
        var valorMensual = 25000D;

        if (periodicidad == Periodicidad.SEMANAL) {
            while (valor > 0) {
                var valorAdd = valor - valorSemana > 0 ? valorSemana : valor;
                cuotas.add(new Cuota(new CuotaId(), valorAdd, fecha, null));

                valor -= valorSemana;
                fecha.plusDays(7);
            }
        }

        if (periodicidad == Periodicidad.QUINCENAL) {
            while (valor > 0) {
                var valorAdd = valor - valorQuincena > 0 ? valorQuincena : valor;
                cuotas.add(new Cuota(new CuotaId(), valorAdd, fecha, null));

                valor -= valorQuincena;
                fecha.plusDays(15);
            }
        }

        if (periodicidad == Periodicidad.MENSUAL) {
            while (valor > 0) {
                var valorAdd = valor - valorSemana > 0 ? valorMensual : valor;
                cuotas.add(new Cuota(new CuotaId(), valorAdd, fecha, null));

                valor -= valorSemana;
                fecha.plusDays(30);
            }
        }
    }

    public Fecha fechaInicial() {
        return fechaInicial;
    }

    public FormaPago formaPago() {
        return formaPago;
    }

    public Set<Cuota> cuotas() {
        return cuotas;
    }

    public CuotaInicial cuotaInicial() {
        return cuotaInicial;
    }
}
