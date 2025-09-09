class CajaMagica<T> {
    private T contenido;

    public void guardar(T item) {
        this.contenido = item;
        System.out.println("Guardado: " + item);
    }

    public T obtener() {
        System.out.println("Obteniendo: " + contenido);
        return contenido;
    }

    public void mostrarTipo() {
        System.out.println("Tipo almacenado: " + contenido.getClass().getSimpleName());
    }
}

public class ProGen {
    public static void main(String[] args) {
        System.out.println("CAJA MÁGICA GENÉRICA \n");

        CajaMagica<String> cajaTexto = new CajaMagica<>();
        cajaTexto.guardar("Hola Mundo");
        cajaTexto.mostrarTipo();
        String texto = cajaTexto.obtener();

        System.out.println();

        CajaMagica<Integer> cajaNumero = new CajaMagica<>();
        cajaNumero.guardar(42);
        cajaNumero.mostrarTipo();
        int numero = cajaNumero.obtener();

        System.out.println();

        CajaMagica<Double> cajaDecimal = new CajaMagica<>();
        cajaDecimal.guardar(3.1416);
        cajaDecimal.mostrarTipo();
        double decimal = cajaDecimal.obtener();
    }
}