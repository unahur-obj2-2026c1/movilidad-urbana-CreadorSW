package ar.edu.unahur.obj2.uml;

import ar.edu.unahur.obj2.uml.Alquiler;
import ar.edu.unahur.obj2.uml.Usuario;
import ar.edu.unahur.obj2.uml.vehiculos.Vehiculo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
Esto es para que smu se comporte como un objeto singleton que coordina.

private static final Smu instance: Al ser static, la instancia pertenece a la clase y no a un objeto en particular. Al ser final, te aseguras de que nadie pueda cambiar esa referencia una vez creada.

private Smu() {}: Este es el "candado". Al ser privado, ninguna otra clase puede hacer un new Smu(), garantizando que la única forma de obtenerlo sea a través de tu método.

public static Smu getInstance(): Es el punto de acceso global. Es static para que puedas llamarlo usando Smu.getInstance() sin necesidad de tener un objeto previo.

*/

public class Smu {

    private static final Smu instance = new Smu();

    private Smu() {} // constructor privado

    public static Smu getInstance() {
        return instance;
    }

    private List<Alquiler> alquileres = new ArrayList<>();
    private List<Vehiculo> vehiculosDisponibles = new ArrayList<>();

    public void registrarAlquiler(
        Usuario usuario,
        Vehiculo vehiculo,
        int cantidadDias
    ) {
        // Smu crea las fechas en el momento de la operación
        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaFin = fechaInicio.plusDays(cantidadDias);

        //constructor de Alquiler
        Alquiler nuevoAlquiler = new Alquiler(
            fechaInicio,
            fechaFin,
            vehiculo,
            usuario
        );

        // cambiar estado interno de vehiculo.
        vehiculo.setDisponible(false);
        // Quitar de disponibles
        vehiculosDisponibles.remove(vehiculo);

        // Guarda el alquiler en la lista
        this.alquileres.add(nuevoAlquiler);
    }

    public void terminarAlquiler(Usuario usuario, Vehiculo vehiculo) {
        alquileres.removeIf(
            alquiler ->
                alquiler.getUsuario().equals(usuario) &&
                alquiler.getVehiculo().equals(vehiculo)
        );
        vehiculo.setDisponible(true);
        vehiculosDisponibles.add(vehiculo);
    }

    public List<Vehiculo> getVehiculosDisponibles() {
        return this.vehiculosDisponibles;
    }

    public List<Alquiler> getAlquileresActivos() {
        return this.alquileres;
    }
}
