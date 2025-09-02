package Practica1;

import java.util.Scanner;

public class Practica1Cajero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServicioCajero cajero = new ServicioCajero();
        int intentos = 0;
        boolean salir = false;
        boolean autenticado = false;

        System.out.println("=== Bienvenido al Cajero ===");

        while (intentos < 3 && !autenticado) {
            System.out.print("Ingrese su PIN: ");
            String pin = scanner.nextLine();
            autenticado = cajero.autenticar(pin);
            if (!autenticado) {
                System.out.println("PIN incorrecto.");
                intentos++;
            }
        }

        if (!autenticado) {
            System.out.println("Demasiados intentos fallidos. Adiós.");
            return;
        }

        System.out.println("Bienvenido, " + cajero.getNombreUsuarioActual());

        while (!salir) {
            System.out.println("\n1. Ver saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.println("Su saldo es: $" + cajero.consultarSaldo());
            } else if (opcion == 2) {
                System.out.print("Ingrese cantidad a retirar: ");
                double retiro = scanner.nextDouble();
                if (cajero.retirar(retiro)) {
                    System.out.println("Retiro exitoso. Nuevo saldo: $" + cajero.consultarSaldo());
                } else {
                    System.out.println("Fondos insuficientes.");
                }
            } else if (opcion == 3) {
                System.out.print("Ingrese cantidad a depositar: ");
                double deposito = scanner.nextDouble();
                cajero.depositar(deposito);
                System.out.println("Depósito exitoso. Nuevo saldo: $" + cajero.consultarSaldo());
            } else if (opcion == 4) {
                salir = true;
                System.out.println("Gracias por usar el cajero.");
                cajero.cerrarSesion();
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }
}
