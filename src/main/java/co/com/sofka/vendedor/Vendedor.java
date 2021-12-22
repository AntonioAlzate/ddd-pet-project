package co.com.sofka.vendedor;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generics.Direccion;
import co.com.sofka.generics.Estado;
import co.com.sofka.generics.PersonaId;
import co.com.sofka.vendedor.events.DireccionVendedorActualizada;
import co.com.sofka.vendedor.events.EstadoVendedorActualizado;
import co.com.sofka.vendedor.events.VendedorCreado;
import co.com.sofka.vendedor.values.VendedorId;

import java.util.List;
import java.util.Objects;

public class Vendedor extends AggregateEvent<VendedorId> {

    protected PersonaId personaId;
    protected RegistroDespacho registroDespacho;
    protected Estado estado;
    protected Direccion direccion;

    public Vendedor(VendedorId entityId, PersonaId personaId, RegistroDespacho registroDespacho, Direccion direccion) {
        super(entityId);
        Objects.requireNonNull(personaId, "el id persona es requerido");
        Objects.requireNonNull(registroDespacho, "el registro de despacho es requerido");
        Objects.requireNonNull(direccion, "la direccion es requerida");

        appendChange(new VendedorCreado(entityId, personaId, registroDespacho, direccion)).apply();
    }

    private Vendedor(VendedorId entityId) {
        super(entityId);
        subscribe(new VendedorChange(this));
    }

    public static Vendedor from(VendedorId vendedorId, List<DomainEvent> event) {
        var vendedor = new Vendedor(vendedorId);
        event.forEach(vendedor::applyEvent);
        return vendedor;
    }

    public void cambiarEstado(Estado estado) {
        Objects.requireNonNull(estado);

        appendChange(new EstadoVendedorActualizado(estado)).apply();
    }

    public void actualizarDireccion(Direccion direccion) {
        Objects.requireNonNull(direccion);

        appendChange(new DireccionVendedorActualizada(direccion)).apply();
    }

    public PersonaId personaId() {
        return personaId;
    }

    public RegistroDespacho registroDespacho() {
        return registroDespacho;
    }

    public Estado estado() {
        return estado;
    }

    public Direccion direccion() {
        return direccion;
    }
}
