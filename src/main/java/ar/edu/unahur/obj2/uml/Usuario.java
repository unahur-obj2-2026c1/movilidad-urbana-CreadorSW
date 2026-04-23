package ar.edu.unahur.obj2.uml;

import ar.edu.unahur.obj2.uml.vehiculos.Vehiculo;

public class Usuario {

    private String nombre;
    private Vehiculo vehiculoAlquilado;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public void alquilarVehiculo(Vehiculo vehiculo, int cantidadDias) {
        Smu.getInstance().registrarAlquiler(this, vehiculo, cantidadDias);
        this.vehiculoAlquilado = vehiculo;
    }

    public void devolverVehiculo() {
        Smu.getInstance().terminarAlquiler(this, this.vehiculoAlquilado);
        this.vehiculoAlquilado = null;
    }
}
