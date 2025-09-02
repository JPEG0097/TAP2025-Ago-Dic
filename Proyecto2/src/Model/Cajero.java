package Model;
import java.util.HashMap;
import java.util.Map;

public class Cajero {
    public Object view;
    private Map<String, Cuenta> cuentas;
    private Cuenta cuentaActual;

    public Cajero() {
        cuentas = new HashMap<>();
        inicializarCuentas();
    }
    private void inicializarCuentas() {
        cuentas.put("12345", new Cuenta("12345","1111", 5000.0, "Juan Perez"));
        cuentas.put("67890", new Cuenta("67890","2222", 500.0, "Perez"));
        cuentas.put("11111", new Cuenta("11111","2121", 50000.0, "Juan"));
        cuentas.put("22222", new Cuenta("22222","1212", 50.0, "Juanpi"));
    }

    public boolean autenticacion(String numCuenta, String pin){
        Cuenta cuenta = cuentas.get(numCuenta);
        if (cuenta != null && cuenta.validarPin(pin)) {
            this.cuentaActual = cuenta;
            return true;
        }
        this.cuentaActual = null;
        return false;
    }
    public Cuenta getCuentaActual() {
        return this.cuentaActual;
    }
    public double consultarSaldo(){
        return (this.cuentaActual != null) ? this.cuentaActual.getSaldo() : 0;
    }
    public boolean realizarRetiro(double cantidad){
        return cuentaActual != null && cuentaActual.retirar(cantidad);
    }
    public boolean realizarDeposito(double cantidad){
        if (cuentaActual != null && cantidad > 0){
            cuentaActual.depositar(cantidad);
            return true;
        }
        return false;
    }
    public boolean cuentaExiste(String numCuenta){
        return cuentas.containsKey(numCuenta);
    }
}
