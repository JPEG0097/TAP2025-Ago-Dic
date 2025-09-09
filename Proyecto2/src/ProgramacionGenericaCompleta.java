import java.util.List;

// 1. CLASE GENÉRICA
class Caja<T> {
    private T contenido;

    public Caja(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }
}

// 2. INTERFACE GENÉRICA
interface Operacion<T> {
    T ejecutar(T a, T b);
}

// 3. IMPLEMENTACIÓN DE INTERFACE
class Suma implements Operacion<Integer> {
    public Integer ejecutar(Integer a, Integer b) {
        return a + b;
    }
}

// 4. CLASE CON RESTRICCIÓN DE TIPOS
class Calculadora<T extends Number> {
    private T numero;

    public Calculadora(T numero) {
        this.numero = numero;
    }

    public double getDoble() {
        return numero.doubleValue() * 2;
    }
}

// 5. CLASE CON MÚLTIPLES TIPOS GENÉRICOS
class Par<K, V> {
    private K clave;
    private V valor;

    public Par(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave() { return clave; }
    public V getValor() { return valor; }
}

// 6. CLASE CON MÉTODOS DE UTILIDAD
class Utilidad {
    // Método genérico
    public static <T> void imprimir(T elemento) {
        System.out.println(elemento);
    }

    // Método con wildcard
    public static void imprimirLista(List<?> lista) {
        for (Object elemento : lista) {
            System.out.println(elemento);
        }
    }
}

// CLASE PRINCIPAL
public class ProgramacionGenericaCompleta {

    public static void main(String[] args) {
        System.out.println("=== 1. CLASE GENÉRICA ===");
        Caja<String> cajaTexto = new Caja<>("Hola Mundo");
        System.out.println(cajaTexto.getContenido());

        Caja<Integer> cajaNumero = new Caja<>(42);
        System.out.println(cajaNumero.getContenido());

        System.out.println("\n=== 2. MÉTODO GENÉRICO ===");
        Utilidad.imprimir("Texto Genérico");
        Utilidad.imprimir(123);
        Utilidad.imprimir(3.14);

        System.out.println("\n=== 3. INTERFACE GENÉRICA ===");
        Suma suma = new Suma();
        System.out.println(suma.ejecutar(10, 5));

        System.out.println("\n=== 4. RESTRICCIÓN DE TIPOS ===");
        Calculadora<Integer> calc1 = new Calculadora<>(10);
        System.out.println(calc1.getDoble());

        Calculadora<Double> calc2 = new Calculadora<>(5.5);
        System.out.println(calc2.getDoble());

        System.out.println("\n=== 5. WILDCARDS ===");
        List<Integer> numeros = List.of(1, 2, 3);
        List<String> palabras = List.of("Java", "Genéricos");
        Utilidad.imprimirLista(numeros);
        Utilidad.imprimirLista(palabras);

        System.out.println("\n=== 6. MÚLTIPLES TIPOS ===");
        Par<String, Integer> edadPersona = new Par<>("Carlos", 25);
        System.out.println(
                edadPersona.getClave() + " tiene " +
                        edadPersona.getValor() + " años"
        );
    }
}