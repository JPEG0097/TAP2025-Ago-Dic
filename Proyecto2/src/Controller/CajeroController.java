package Controller;

import Model.Cajero;
import View.CajeroView;

public class CajeroController {
    private Cajero model;
    private CajeroView view;

    public CajeroController(Cajero model, CajeroView view) {
        this.model = model;
        this.view = view;
    }

    public CajeroController(Object view) {
    }

    public void iniciarSistema() {
        while (true) {
            view.mostrarBienvenida();
            String numCuenta = view.solicitarNumeroCuenta();
            String pin = view.solicitarPin();

            if (model.autenticacion(numCuenta, pin)) {
                String titular = model.getCuentaActual().getTitular();
                boolean salir = false;
                while (!salir) {
                    view.mostrarMenuPrincipal(titular);
                    int opcion = view.leerOpcion();
                    switch (opcion) {
                        case 1:
                            double saldo = model.consultarSaldo();
                            view.mostrarSaldo(saldo);
                            break;
                        case 2:
                            double cantidadRetiro = view.solicitarCantidad("retirar");
                            if (cantidadRetiro > 0) {
                                if (model.realizarRetiro(cantidadRetiro)) {
                                    view.mostrarMensaje("Retiro exitoso");
                                } else {
                                    view.mostrarMensaje("Fondos insuficientes");
                                }
                            } else {
                                view.mostrarMensaje("Cantidad inválida");
                            }
                            break;
                        case 3:
                            double cantidadDeposito = view.solicitarCantidad("depositar");
                            if (cantidadDeposito > 0) {
                                if (model.realizarDeposito(cantidadDeposito)) {
                                    view.mostrarMensaje("Depósito exitoso");
                                } else {
                                    view.mostrarMensaje("Error al depositar");
                                }
                            } else {
                                view.mostrarMensaje("Cantidad inválida");
                            }
                            break;
                        case 9:
                            salir = true;
                            view.mostrarMensaje("Sesión finalizada. ¡Hasta luego!");
                            break;
                        default:
                            view.mostrarMensaje("Opción no válida");
                            break;
                    }
                }
            } else {
                view.mostrarMensaje("Autenticación fallida. Intente nuevamente.");
            }
        }
    }
}
