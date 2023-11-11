package junto;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca extends Socio {
    public Biblioteca(int numeroSocio, String nombre, String direccion) {
        super(numeroSocio, nombre, direccion);
        //TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        // Crear instancias para demostrar el funcionamiento

        // Crear libros
        Libro libro1 = new Libro(1, "Libro1", "Autor1");
        Libro libro2 = new Libro(2, "Libro2", "Autor2");

        // Crear socios
        Socio socio1 = new Socio(101, "Socio1", "Direccion1");
        Socio socio2 = new Socio(102, "Socio2", "Direccion2");

        // Hacer que los socios tomen prestados libros
        socio1.tomarPrestado(libro1, new Date(0));
        socio1.tomarPrestado(libro2, new Date(0));
        socio2.tomarPrestado(libro1, new Date(0));

        // Mostrar estado de los libros
        System.out.println("Estado de los libros:");
        System.out.println("Libro1 disponible: " + libro1.isDisponible());
        System.out.println("Libro2 disponible: " + libro2.isDisponible());

        // Mostrar socios que tienen prestados más de 3 libros (ninguno en este caso)
        List<Socio> sociosConMasDeTresLibros = buscarSociosConMasDeTresLibros(List.of(socio1, socio2));
        System.out.println("Socios con más de 3 libros prestados:");
        for (Socio socio : sociosConMasDeTresLibros) {
            System.out.println("Socio: " + socio.getNombre());
        }
    }

    // Función para buscar socios que tengan prestados más de 3 libros
    private static List<Socio> buscarSociosConMasDeTresLibros(List<Socio> socios) {
        return socios.stream()
            .filter(socio -> socio.getPrestamos().size() > 3)
            .collect(Collectors.toList());
    }
}
