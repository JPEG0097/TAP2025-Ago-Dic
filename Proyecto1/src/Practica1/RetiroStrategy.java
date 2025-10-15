package Practica1;

public class RetiroStrategy implements OperacionStrategy {
    @Override
    public void ejecutar(ServicioCajero cajero, double cantidad) {
        if (!cajero.retirar(cantidad)) {
            System.out.println("Fondos insuficientes para el retiro.");
        } else {
            System.out.println("Retiro exitoso: $" + cantidad);
        }
    }
}
