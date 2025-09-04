package View;

import Controller.CajeroController;
import Model.Cajero;

public class CajeroAutomatico {
    public static void main(String[] args) {

        Cajero model = new Cajero();
        CajeroView view = new CajeroView();
        CajeroController controller = new CajeroController(model, view);
        controller.iniciarSistema();
    }
}
