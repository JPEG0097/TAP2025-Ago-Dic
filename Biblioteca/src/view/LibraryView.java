package view;

import model.Book;
import model.Magazine;
import java.util.List;

public class LibraryView {

    public void displayBook(Book book) {
        System.out.println("\n=== DETALLES DEL LIBRO ===");
        System.out.println("ID: " + book.getId());
        System.out.println("Título: " + book.getTitle());
        System.out.println("Autor: " + book.getAuthor());
        System.out.println("Año: " + book.getYear());
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("Páginas: " + book.getPages());
        System.out.println("Estado: " + (book.isAvailable() ? "Disponible" : "Prestado"));
        System.out.println("==========================");
    }

    public void displayMagazine(Magazine magazine) {
        System.out.println("\n=== DETALLES DE LA REVISTA ===");
        System.out.println("ID: " + magazine.getId());
        System.out.println("Título: " + magazine.getTitle());
        System.out.println("Editorial: " + magazine.getPublisher());
        System.out.println("Año: " + magazine.getYear());
        System.out.println("Número: " + magazine.getIssueNumber());
        System.out.println("Categoría: " + magazine.getCategory());
        System.out.println("Estado: " + (magazine.isAvailable() ? "Disponible" : "Prestado"));
        System.out.println("=============================");
    }

    public void displayAllItems(List<Book> books, List<Magazine> magazines) {
        System.out.println("\n=== TODOS LOS ITEMS DE LA BIBLIOTECA ===");

        System.out.println("\n LIBROS (" + books.size() + "):");
        for (Book book : books) {
            System.out.println("• " + book.getTitle() + " - " + book.getAuthor() +
                    " (" + book.getYear() + ") - " +
                    (book.isAvailable() ? "si" : "no"));
        }

        System.out.println("\n REVISTAS (" + magazines.size() + "):");
        for (Magazine magazine : magazines) {
            System.out.println("• " + magazine.getTitle() + " - Ed." + magazine.getIssueNumber() +
                    " (" + magazine.getYear() + ") - " +
                    (magazine.isAvailable() ? "si" : "no"));
        }

        System.out.println("========================================");
    }

    public void displayAvailableItems(List<Book> availableBooks, List<Magazine> availableMagazines) {
        System.out.println("\n=== ITEMS DISPONIBLES ===");

        System.out.println("\n LIBROS DISPONIBLES (" + availableBooks.size() + "):");
        for (Book book : availableBooks) {
            System.out.println("• " + book.getTitle() + " - " + book.getAuthor());
        }

        System.out.println("\n REVISTAS DISPONIBLES (" + availableMagazines.size() + "):");
        for (Magazine magazine : availableMagazines) {
            System.out.println("• " + magazine.getTitle() + " - Ed." + magazine.getIssueNumber());
        }

        System.out.println("==========================");
    }

    public void displayStatistics(int totalBooks, int availableBooks,
                                  int totalMagazines, int availableMagazines) {
        System.out.println("\n=== ESTADÍSTICAS DE LA BIBLIOTECA ===");
        System.out.println("Libros: " + availableBooks + "/" + totalBooks + " disponibles");
        System.out.println("Revistas: " + availableMagazines + "/" + totalMagazines + " disponibles");
        System.out.println("Total: " + (availableBooks + availableMagazines) + "/" +
                (totalBooks + totalMagazines) + " disponibles");
        System.out.println("=====================================");
    }

    public void displayMessage(String message) {
        System.out.println("\n" + message);
    }

    public void displayMenu() {
        System.out.println("\n=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===");
        System.out.println("1. Agregar libro (Novela)");
        System.out.println("2. Agregar libro (Texto)");
        System.out.println("3. Agregar revista científica");
        System.out.println("4. Mostrar todos los items");
        System.out.println("5. Mostrar items disponibles");
        System.out.println("6. Prestar libro");
        System.out.println("7. Devolver libro");
        System.out.println("8. Prestar revista");
        System.out.println("9. Mostrar estadísticas");
        System.out.println("10. Salir");
        System.out.print("Seleccione una opción: ");
    }
}