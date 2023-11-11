import java.util.ArrayList;
import java.util.List;

// Clase base para los objetos representables
class ObjetoRepresentable {
    // Puedes añadir más propiedades según sea necesario
    static String nombre;

    public ObjetoRepresentable(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

// Clase para representar textos
class Texto extends ObjetoRepresentable {
    private String contenido;

    public Texto(String nombre, String contenido) {
        super(nombre);
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}

// Clase para representar objetos geométricos
class ObjetoGeometrico extends ObjetoRepresentable {

    public ObjetoGeometrico(String nombre) {
        super(nombre);
        //TODO Auto-generated constructor stub
    }
    // Puedes añadir más propiedades según sea necesario
}

// Clases específicas para círculos, elipses, rectángulos, líneas y cuadrados
class Circulo extends ObjetoGeometrico {

    public Circulo(String nombre) {
        super(nombre);
        //TODO Auto-generated constructor stubtación 
    // Implementación específica para círculos
}

class Elipse extends ObjetoGeometrico {

    public Elipse(String nombre) {
        super(nombre);
        //TODO Auto-generated constructor stub
    }
    // Implementación específica para elipses
}

class Rectangulo extends ObjetoGeometrico {

    public Rectangulo(String nombre) {
        super(nombre);
        //TODO Auto-generated constructor stub
    }
    // Implementación específica para rectángulos
}

class Linea extends ObjetoGeometrico {

    public Linea(String nombre) {
        super(nombre);
        //TODO Auto-generated constructor stub
    }
    // Implementación específica para líneas
}

class Cuadrado extends ObjetoGeometrico {

    public Cuadrado(String nombre) {
        super(nombre);
        //TODO Auto-generated constructor stub
    }
    // Implementación específica para cuadrados
}

// Clase para representar grupos de objetos representables
class Grupo extends ObjetoRepresentable {
    private List<ObjetoRepresentable> objetos;

    public Grupo(String nombre) {
        super(nombre);
        this.objetos = new ArrayList<>();
    }

    public List<ObjetoRepresentable> getObjetos() {
        return objetos;
    }

    public void agregarObjeto(ObjetoRepresentable objeto) {
        objetos.add(objeto);
    }

    public void removerObjeto(ObjetoRepresentable objeto) {
        objetos.remove(objeto);
    }
}

public class EditorGrafico {
    public static void main(String[] args) {
        // Crear instancias para demostrar el uso exhaustivo
        Texto texto = new Texto("Texto1", "Hola, soy un texto.");
        Circulo circulo = new Circulo(nombre);
        Grupo grupo1 = new Grupo("Grupo1");

        grupo1.agregarObjeto(texto);
        grupo1.agregarObjeto(circulo);

        Cuadrado cuadrado = new Cuadrado("Cuadrado1");

        // Puedes seguir creando instancias y demostrar más funcionalidades del editor gráfico
    }
}
