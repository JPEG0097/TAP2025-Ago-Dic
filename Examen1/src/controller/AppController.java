package controller;

import model.Client;
import model.Product;
import repository.InMemoryRepository;
import service.ClientService;
import service.InventoryService;
import view.ConsoleView;

import java.util.List;
import java.util.Optional;

public class AppController {
    private final ConsoleView view;
    private final InventoryService inventoryService;
    private final ClientService clientService;

    public AppController() {
        this.view = new ConsoleView();
        this.inventoryService = new InventoryService(new InMemoryRepository<>(Product::getId));
        this.clientService = new ClientService(new InMemoryRepository<>(Client::getId));
        seed();
    }

    private void seed() {
        inventoryService.seed();
        clientService.seed();
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            int op = view.mainMenu();
            switch (op) {
                case 1 -> productsFlow();
                case 2 -> clientsFlow();
                case 5 -> {
                    view.showMessage("¡Gracias por usar el sistema!");
                    exit = true;
                }
                default -> view.showMessage("Opción no válida.");
            }
        }
    }

    private void productsFlow() {
        boolean back = false;
        while (!back) {
            int op = view.productsMenu();
            switch (op) {
                case 1 -> addProduct();
                case 2 -> modifyProduct();
                case 3 -> deleteProduct();
                case 4 -> view.displayProducts(inventoryService.listAll());
                case 5 -> searchProduct();
                case 6 -> back = true;
                default -> view.showMessage("Opción no válida.");
            }
        }
    }

    private void clientsFlow() {
        boolean back = false;
        while (!back) {
            int op = view.clientsMenu();
            switch (op) {
                case 1 -> addClient();
                case 2 -> modifyClient();
                case 3 -> deleteClient();
                case 4 -> view.displayClients(clientService.listAll());
                case 5 -> searchClient();
                case 6 -> back = true;
                default -> view.showMessage("Opción no válida.");
            }
        }
    }

    private void addProduct() {
        Product p = view.readProductForm(false, new Product("", "", 0, 0, "", null));
        if (inventoryService.addProduct(p)) {
            view.showMessage("Producto agregado con éxito.");
        } else {
            view.showMessage("Error: El código ya existe.");
        }
    }

    private void modifyProduct() {
        String code = view.readLine("\nIngrese el código a modificar: ");
        Optional<Product> current = inventoryService.findByCode(code);
        if (current.isEmpty()) { view.showMessage("No existe ese código."); return; }
        Product updated = view.readProductForm(true, current.get());
        if (inventoryService.updateProduct(updated)) view.showMessage("Producto modificado con éxito.");
        else view.showMessage("No se pudo modificar.");
    }

    private void deleteProduct() {
        String code = view.readLine("\nIngrese el código a eliminar: ");
        if (inventoryService.deleteProduct(code)) view.showMessage("Producto eliminado.");
        else view.showMessage("No existe ese código.");
    }

    private void searchProduct() {
        int op = Integer.parseInt(view.readLine("\n1) Buscar por Código  2) Buscar por Nombre: "));
        switch (op) {
            case 1 -> {
                String code = view.readLine("Código: ");
                inventoryService.findByCode(code).ifPresentOrElse(
                        p -> { view.showMessage("\nDetalle del Producto:"); view.showMessage("Código: " + p.getCode()); view.showMessage("Nombre: " + p.getName()); view.showMessage("Precio: $" + p.getPrice()); view.showMessage("Cantidad: " + p.getQuantity()); view.showMessage("Categoría: " + p.getCategory()); view.showMessage("Vencimiento: " + (p.getExpiryDate()!=null?p.getExpiryDate():"N/A")); },
                        () -> view.showMessage("No encontrado.")
                );
            }
            case 2 -> {
                String name = view.readLine("Nombre (fragmento): ");
                List<Product> found = inventoryService.searchByName(name);
                if (found.isEmpty()) view.showMessage("Sin coincidencias.");
                else view.displayProducts(found);
            }
            default -> view.showMessage("Opción no válida.");
        }
    }

    private void addClient() {
        String name = view.readLine("Nombre: ");
        String email = view.readLine("Email: ");
        String phone = view.readLine("Teléfono: ");
        double balance = Double.parseDouble(view.readLine("Saldo inicial: "));
        Client c = clientService.addClient(name, email, phone, balance);
        view.showMessage("Cliente agregado con ID: " + c.getId());
    }

    private void modifyClient() {
        int id = Integer.parseInt(view.readLine("ID del cliente a modificar: "));
        Optional<Client> opt = clientService.findById(id);
        if (opt.isEmpty()) { view.showMessage("No existe ese cliente."); return; }
        Client current = opt.get();
        String name = orKeep(view.readLine("Nombre [" + current.getName() + "]: "), current.getName());
        String email = orKeep(view.readLine("Email [" + current.getEmail() + "]: "), current.getEmail());
        String phone = orKeep(view.readLine("Teléfono [" + current.getPhone() + "]: "), current.getPhone());
        String bStr = view.readLine("Saldo [" + current.getBalance() + "]: ");
        double balance = bStr.isEmpty() ? current.getBalance() : Double.parseDouble(bStr);
        Client updated = new Client(current.getId(), name, email, phone, balance);
        if (clientService.updateClient(updated)) view.showMessage("Cliente modificado.");
    }

    private void deleteClient() {
        int id = Integer.parseInt(view.readLine("ID del cliente a eliminar: "));
        if (clientService.deleteClient(id)) view.showMessage("Cliente eliminado.");
        else view.showMessage("No existe ese cliente.");
    }

    private void searchClient() {
        int op = Integer.parseInt(view.readLine("\n1) Buscar por Nombre  2) Buscar por Email: "));
        switch (op) {
            case 1 -> {
                String q = view.readLine("Nombre (fragmento): ");
                List<Client> found = clientService.searchByName(q);
                if (found.isEmpty()) view.showMessage("Sin coincidencias.");
                else view.displayClients(found);
            }
            case 2 -> {
                String q = view.readLine("Email (fragmento): ");
                List<Client> found = clientService.searchByEmail(q);
                if (found.isEmpty()) view.showMessage("Sin coincidencias.");
                else view.displayClients(found);
            }
            default -> view.showMessage("Opción no válida.");
        }
    }

    private static String orKeep(String value, String current) { return value == null || value.isEmpty() ? current : value; }
}