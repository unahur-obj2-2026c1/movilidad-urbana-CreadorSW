package ar.edu.unahur.obj2.uml.vehiculos;

public abstract class Vehiculo {

    protected boolean disponible = true;

    public Vehiculo() {}

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
