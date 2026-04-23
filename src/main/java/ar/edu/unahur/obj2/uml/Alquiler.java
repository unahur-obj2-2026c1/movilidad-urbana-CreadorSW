package ar.edu.unahur.obj2.uml;

import ar.edu.unahur.obj2.uml.vehiculos.Vehiculo;
import java.time.LocalDate;

public class Alquiler {

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Vehiculo vehiculo;
    private Usuario usuario;

    public Alquiler(
        LocalDate fechaInicio,
        LocalDate fechaFin,
        Vehiculo vehiculo,
        Usuario usuario
    ) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.vehiculo = vehiculo;
        this.usuario = usuario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }
}
