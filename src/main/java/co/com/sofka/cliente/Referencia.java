package co.com.sofka.cliente;

import co.com.sofka.cliente.enums.Parentesco;
import co.com.sofka.cliente.values.Nombre;
import co.com.sofka.cliente.values.ReferenciaId;
import co.com.sofka.cliente.values.Telefono;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Referencia extends Entity<ReferenciaId> {

    private Parentesco parentesco;
    private Telefono telefono;
    private Nombre nombre;

    public Referencia(ReferenciaId entityId, Nombre nombre, Telefono telefono, Parentesco parentesco) {
        super(entityId);
        this.nombre = Objects.requireNonNull(nombre);
        this.telefono = Objects.requireNonNull(telefono);
        this.parentesco = Objects.requireNonNull(parentesco);
    }

    public void actualizarTelefono(Telefono telefono) {
        Objects.requireNonNull(telefono, "el telefono no puede ser null");

    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void actualizarParentesco(Parentesco parentesco) {
        this.parentesco = Objects.requireNonNull(parentesco);
    }

    public Parentesco parentesco() {
        return parentesco;
    }

    public Telefono telefono() {
        return telefono;
    }

    public Nombre nombre() {
        return nombre;
    }
}
