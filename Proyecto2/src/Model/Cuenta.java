package Model;

public class Cuenta {
    private String numCuenta;
    private String pin;
    private Double saldoInicial;
    private String titular;

    public Cuenta(String numCuenta, String pin, Double saldoInicial, String titular) {
        this.numCuenta = numCuenta;
        this.pin = pin;
        this.saldoInicial = saldoInicial;
        this.titular = titular;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public String getPin() {
        return pin;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public boolean validarPin(String pin) {
        return pin.equals(this.pin);
    }

    public boolean retirar(double cantidad) {
        if (cantidad <= this.saldoInicial) {
            saldoInicial -= cantidad;
            return true;
        }
        return false;
    }

    public Double getSaldo() {
        return saldoInicial;
    }

    public void depositar(double cantidad) {
    }
}

