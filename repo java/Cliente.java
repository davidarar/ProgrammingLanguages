import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Implementación del Singleton Eager para ContactosAgenda
class ContactosAgenda {
    private static final ContactosAgenda instancia = new ContactosAgenda();

    private ContactosAgenda() {
        // Constructor privado para prevenir instanciación externa
    }

    public static ContactosAgenda getInstancia() {
        return instancia;
    }

    // Resto de la implementación de ContactosAgenda...
}

// Implementación del Singleton Lazy para EventosAgenda
class EventosAgenda {
    private static EventosAgenda instancia;

    private EventosAgenda() {
        // Constructor privado para prevenir instanciación externa
    }

    public static synchronized EventosAgenda getInstancia() {
        if (instancia == null) {
            instancia = new EventosAgenda();
        }
        return instancia;
    }

    // Resto de la implementación de EventosAgenda...
}

// Interfaz para la Abstract Factory
interface AgendaFactory {
    Contacto crearContacto();

    Evento crearEvento();
}

// Implementación de la Abstract Factory
class SimpleAgendaFactory implements AgendaFactory {
    @Override
    public Contacto crearContacto() {
        return new Contacto();
    }

    @Override
    public Evento crearEvento() {
        return new Evento();
    }
}

// Clase para representar a un socio
class Socio {
    private int numeroSocio;
    private String nombre;
    private String direccion;
    private List<Prestamo> prestamos;

    public Socio(int numeroSocio, String nombre, String direccion) {
        this.numeroSocio = numeroSocio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.prestamos = new ArrayList<>();
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void tomarPrestado(Libro libro, Date fechaPrestamo) {
        Prestamo prestamo = new Prestamo(libro.getCodigo(), this.numeroSocio, fechaPrestamo);
        prestamos.add(prestamo);
        libro.prestar();
    }
}

// Clase para representar un libro
class Libro {
    private int codigo;
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(int codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void prestar() {
        disponible = false;
    }

    public void devolver() {
        disponible = true;
    }
}

// Clase para representar un préstamo
class Prestamo {
    private int codigoLibro;
    private int numeroSocio;
    private Date fecha;

    public Prestamo(int codigoLibro, int numeroSocio, Date fecha) {
        this.codigoLibro = codigoLibro;
        this.numeroSocio = numeroSocio;
        this.fecha = fecha;
    }

    public int getCodigoLibro() {
        return codigoLibro;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public Date getFecha() {
        return fecha;
    }
}

// Clase para representar un contacto
class Contacto {
    // Implementación de la clase Contacto...
}

// Clase para representar un evento
class Evento {
    // Implementación de la clase Evento...
}

// Clase cliente que utiliza la Abstract Factory
public class Cliente {
    private AgendaFactory factory;

    public Cliente(AgendaFactory factory) {
        this.factory = factory;
    }

    public void crearYAgregarContacto() {
        Contacto nuevoContacto = factory.crearContacto();
        // Lógica para agregar el nuevo contacto a la agenda...
    }

    public void crearYAgregarEvento() {
        Evento nuevoEvento = factory.crearEvento();
        // Lógica para agregar el nuevo evento a la agenda...
    }

    // Método principal para demostrar el funcionamiento
    public static void main(String[] args) {
        // Crear instancias y demostrar el funcionamiento del sistema...
    }

    // Función para buscar socios que tengan prestados más de 3 libros
    private static List<Socio> buscarSociosConMasDeTresLibros(List<Socio> socios) {
        return socios.stream()
                .filter(socio -> socio.getPrestamos().size() > 3)
                .collect(Collectors.toList());
    }
}
