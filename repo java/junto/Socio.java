package junto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

// Clase para representar a un socio
public class Socio {
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
public class Libro {
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
public cclass Prestamo {
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
