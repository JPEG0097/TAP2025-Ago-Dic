package inventory.view;

import inventory.model.Client;
import inventory.model.Product;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public int mainMenu() {
        System.out.println("\n===== SISTEMA DE INVENTARIO (MVC) =====");
        System.out.println("1. Gestionar Productos");
        System.out.println("2. Gestionar Clientes");
        System.out.println("5. Guardar y Salir");
        System.out.print("Seleccione una opción: ");
        return readInt();
    }

    public int productsMenu() {
        System.out.println("\n----- GESTIÓN DE PRODUCTOS -----");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Modificar Producto");
        System.out.println("3. Eliminar Producto");
        System.out.println("4. Listar Productos");
        System.out.println("5. Buscar Producto");
        System.out.println("6. Volver");
        System.out.print("Seleccione una opción: ");
        return readInt();
    }

    public int clientsMenu() {
        System.out.println("\n----- GESTIÓN DE CLIENTES -----");
        System.out.println("1. Agregar Cliente");
        System.out.println("2. Modificar Cliente");
        System.out.println("3. Eliminar Cliente");
        System.out.println("4. Listar Clientes");
        System.out.println("5. Buscar Cliente");
        System.out.println("6. Volver");
        System.out.print("Seleccione una opción: ");
        return readInt();
    }

    public Product readProductForm(boolean forUpdate, Product current) {
        System.out.println(forUpdate ? "\n--- MODIFICAR PRODUCTO ---" : "\n--- AGREGAR NUEVO PRODUCTO ---");
        System.out.print("Código" + (forUpdate ? " [" + current.getCode() + "]" : "") + ": ");
        String code = forUpdate ? emptyOr(scanner.nextLine(), current.getCode()) : scanner.nextLine();

        System.out.print("Nombre" + (forUpdate ? " [" + current.getName() + "]" : "") + ": ");
        String name = forUpdate ? emptyOr(scanner.nextLine(), current.getName()) : scanner.nextLine();

        System.out.print("Precio" + (forUpdate ? " [" + current.getPrice() + "]" : "") + ": ");
        String pStr = forUpdate ? scanner.nextLine() : null;
        double price = forUpdate ? (pStr.isEmpty() ? current.getPrice() : Double.parseDouble(pStr)) : readDouble();

        System.out.print("Cantidad" + (forUpdate ? " [" + current.getQuantity() + "]" : "") + ": ");
        String qStr = forUpdate ? scanner.nextLine() : null;
        int qty = forUpdate ? (qStr.isEmpty() ? current.getQuantity() : Integer.parseInt(qStr)) : readInt();

        System.out.print("Categoría" + (forUpdate ? " [" + current.getCategory() + "]" : "") + ": ");
        String category = forUpdate ? emptyOr(scanner.nextLine(), current.getCategory()) : scanner.nextLine();

        System.out.print("Fecha de Vencimiento (AAAA-MM-DD)" + (forUpdate ? " [" + (current.getExpiryDate()!=null?current.getExpiryDate().toString():"") + "]" : "") + ": ");
        String fStr = scanner.nextLine();
        java.time.LocalDate expiry = (forUpdate
                ? (fStr.isEmpty() ? current.getExpiryDate() : java.time.LocalDate.parse(fStr))
                : (fStr.isEmpty() ? null : java.time.LocalDate.parse(fStr)));

        return new Product(code, name, price, qty, category, expiry);
    }

    public void displayProducts(List<Product> products) {
        System.out.println("\n--- LISTA DE PRODUCTOS ---");
        System.out.println("Código\tNombre\t\t\tPrecio\tCantidad\tCategoría\tVencimiento");
        System.out.println("--------------------------------------------------------------------------------");
        for (Product p : products) System.out.println(p.toString());
        if (products.isEmpty()) System.out.println("No hay productos registrados.");
    }

    public void displayClients(List<Client> clients) {
        System.out.println("\n--- LISTA DE CLIENTES ---");
        System.out.println("ID  Nombre\t\t\tEmail\t\t\tTeléfono\tSaldo");
        for (Client c : clients) System.out.println(c.toString());
        if (clients.isEmpty()) System.out.println("No hay clientes registrados.");
    }

    public void showMessage(String msg) { System.out.println(msg); }

    public String readLine(String prompt) { System.out.print(prompt); return scanner.nextLine(); }

    public int readInt() {
        while (true) {
            try {
                int v = Integer.parseInt(scanner.nextLine());
                return v;
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }

    public double readDouble() {
        while (true) {
            try {
                double v = Double.parseDouble(scanner.nextLine());
                return v;
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }

    private static String emptyOr(String text, String def) { return text == null || text.isEmpty() ? def : text; }
}