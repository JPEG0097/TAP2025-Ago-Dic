import java.util.Scanner;

public class VerificadorEdad {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingresa tu edad: ");
        int edad = entrada.nextInt();

        mostrarResultado(edad);

        entrada.close();
    }

    public static boolean esMayorDeEdad(int edad) {
        return edad >= 18;
    }

    public static void mostrarResultado(int edad) {
        if (esMayorDeEdad(edad)) {
            System.out.println("Eres mayor de edad.");
        } else {
            System.out.println("Eres menor de edad.");
        }
    }
}
