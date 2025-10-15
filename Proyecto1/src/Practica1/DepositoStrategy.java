package Practica1;

public class DepositoStrategy implements OperacionStrategy {
    @Override
    public void ejecutar(ServicioCajero cajero, double cantidad) {
        cajero.depositar(cantidad);
        System.out.println("Depósito exitoso: $" + cantidad);
    }
}
