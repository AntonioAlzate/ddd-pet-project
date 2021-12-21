package co.com.sofka.cliente;

import co.com.sofka.cliente.enums.Parentesco;
import co.com.sofka.cliente.events.*;
import co.com.sofka.cliente.values.*;
import co.com.sofka.cliente.enums.Estado;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.*;

public class Cliente extends AggregateEvent<ClienteId> {

    protected PersonaId personaId;

    protected Cuenta cuenta;
    protected Set<Referencia> referencias;
    protected Direccion direccion;
    protected Estado estado;

    public Cliente(ClienteId clienteId, PersonaId personaId, Direccion direccion){
        super(clienteId);
        Objects.requireNonNull(personaId, "id persona es requerido");
        Objects.requireNonNull(direccion, "La direccion del cliente es requerida");

        appendChange(new ClienteCreado(personaId, direccion)).apply();
    }

    private Cliente(ClienteId entityId){
        super(entityId);
        subscribe(new ClienteChange(this));
    }

    public static Cliente from(ClienteId clienteId, List<DomainEvent> event){
        var cliente = new Cliente(clienteId);
        event.forEach(cliente::applyEvent);
        return cliente;
    }

    public void agregarReferencia(ReferenciaId entityId, Nombre nombre, Telefono telefono, Parentesco parentesco){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        Objects.requireNonNull(parentesco);
        appendChange(new ReferenciaAgregada(entityId, nombre, telefono, parentesco)).apply();
    }

    public void actualizarSaldoDeudaCuenta(SaldoDeuda saldoDeuda){
        Objects.requireNonNull(saldoDeuda);
        appendChange(new SaldoDeudaActualizada(saldoDeuda)).apply();
    }

    public void actualizarCupoCuenta(Cupo cupo){
        Objects.requireNonNull(cupo);
        appendChange(new CupoCuentaActualizado(cupo)).apply();
    }

    public void actualizarDireccion(Direccion direccion){
        Objects.requireNonNull(direccion);
        appendChange(new DireccionActualizada(direccion)).apply();
    }

    public void actualizarEstadoCliente(Estado estado){
        Objects.requireNonNull(estado);
        appendChange(new EstadoClienteActualizado(estado)).apply();
    }

    public void actualizarParentezcoDeUnaReferencia(ReferenciaId referenciaId, Parentesco parentesco){
        Objects.requireNonNull(referenciaId, "el id de una referencia es requerido");
        Objects.requireNonNull(parentesco, "el parentesco no puede ser null");

        appendChange(new ParentescoDeUnaReferenciaActualizado(referenciaId, parentesco));
    }

    public void actualizarTelefonoDeUnaReferencia(ReferenciaId referenciaId, Telefono telefono){
        Objects.requireNonNull(referenciaId, "el id de una referencia es requerido");
        Objects.requireNonNull(telefono, "el telefono no puede ser null");

        appendChange(new TelefonoDeUnaReferenciaActualizado(referenciaId, telefono));
    }

    public void actualizarNombreDeUnaReferencia(ReferenciaId referenciaId, Nombre nombre){
        Objects.requireNonNull(referenciaId, "el id de una referencia es requerido");
        Objects.requireNonNull(nombre, "el nombre no puede ser null");

        appendChange(new NombreDeUnaReferenciaActualizado(referenciaId, nombre));
    }

    protected Optional<Referencia> obtenerReferenciaPorId(ReferenciaId referenciaId){
        return referencias
                .stream()
                .filter(referencia -> referencia.identity().equals(referenciaId))
                .findFirst();
    }

    public PersonaId personaId() {
        return personaId;
    }

    public Cuenta cuenta() {
        return cuenta;
    }

    public Set<Referencia> referencias() {
        return referencias;
    }

    public Direccion direccion() {
        return direccion;
    }

    public Estado estado() {
        return estado;
    }
}
