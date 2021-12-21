package co.com.sofka.cliente;

import co.com.sofka.cliente.values.CuentaId;
import co.com.sofka.cliente.values.Cupo;
import co.com.sofka.cliente.enums.EstadoCuenta;
import co.com.sofka.cliente.values.SaldoDeuda;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Cuenta extends Entity<CuentaId> {

    private EstadoCuenta estadoCuenta;
    private Cupo cupo;
    private SaldoDeuda saldoDeuda;

    public Cuenta(CuentaId entityId) {
        super(entityId);
        this.estadoCuenta = EstadoCuenta.AL_DIA;
        this.cupo = new Cupo(100000D);
        this.saldoDeuda = new SaldoDeuda(0D);
    }

    public void cambiarEstadoCuenta(EstadoCuenta estadoCuenta){
        this.estadoCuenta = Objects.requireNonNull(estadoCuenta, "El estado de cuenta no puede ser null");
    }

    public void actualizarSaldoDeuda(SaldoDeuda saldoDeuda){
        Objects.requireNonNull(saldoDeuda);
        if(saldoDeuda.getValue() < 0)
            throw new IllegalArgumentException("El valor del cupo no puede ser menor a cero");

        this.saldoDeuda = saldoDeuda;
    }

    public void actualizarCupo(Cupo cupo){
        Objects.requireNonNull(cupo);
        if(cupo.getValue() < 0)
            throw new IllegalArgumentException("El valor del cupo no puede ser menor a cero");

        this.cupo = cupo;
    }

    public EstadoCuenta estadoCuenta() {
        return estadoCuenta;
    }

    public Cupo cupo() {
        return cupo;
    }

    public SaldoDeuda saldoDeuda() {
        return saldoDeuda;
    }
}
