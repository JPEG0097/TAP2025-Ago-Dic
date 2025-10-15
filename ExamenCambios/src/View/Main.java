package View;

import Controller.SistemaController;

public class Main {
    public static void main(String[] args) {
        try {
            startApplication();
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void startApplication() {
        SistemaView view = new SistemaView();
        SistemaController controller = new SistemaController(view);
        controller.iniciar();
    }
}