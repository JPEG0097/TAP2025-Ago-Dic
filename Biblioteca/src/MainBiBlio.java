import model.Book;
import model.Magazine;
import model.LibraryRepository;
import controller.LibraryController;
import view.LibraryView;
import java.util.Scanner;

public class MainBiBlio {
    public static void main(String[] args) {
        // Inicializar
        LibraryRepository<Book> bookRepository = new LibraryRepository<>();
        LibraryRepository<Magazine> magazineRepository = new LibraryRepository<>();
        LibraryView view = new LibraryView();
        LibraryController controller = new LibraryController(bookRepository, magazineRepository, view);

        Scanner scanner = new Scanner(System.in);
        int option;

        // Datos ejemplo
        controller.addNovel("B001", "Cien años de soledad", 1967, "Gabriel García Márquez", "978-8437604947", 471);
        controller.addTextbook("B002", "Introducción a Java", 2020, "James Gosling", "978-0134685991", 928);
        controller.addScienceMagazine(1, "National Geographic", 2023, "National Geographic Society", 245);

        do {
            view.displayMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    System.out.print("ID del libro: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Título: ");
                    String title = scanner.nextLine();
                    System.out.print("Año: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Autor: ");
                    String author = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Páginas: ");
                    int pages = scanner.nextInt();

                    controller.addNovel(bookId, title, year, author, isbn, pages);
                    break;

                case 2:
                    System.out.print("ID del libro: ");
                    String textbookId = scanner.nextLine();
                    System.out.print("Título: ");
                    String textbookTitle = scanner.nextLine();
                    System.out.print("Año: ");
                    int textbookYear = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Autor: ");
                    String textbookAuthor = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String textbookIsbn = scanner.nextLine();
                    System.out.print("Páginas: ");
                    int textbookPages = scanner.nextInt();

                    controller.addTextbook(textbookId, textbookTitle, textbookYear, textbookAuthor, textbookIsbn, textbookPages);
                    break;

                case 3:
                    System.out.print("ID de la revista: ");
                    int magId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Título: ");
                    String magTitle = scanner.nextLine();
                    System.out.print("Año: ");
                    int magYear = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Editorial: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Número de edición: ");
                    int issue = scanner.nextInt();

                    controller.addScienceMagazine(magId, magTitle, magYear, publisher, issue);
                    break;

                case 4:
                    controller.showAllItems();
                    break;

                case 5:
                    controller.showAvailableItems();
                    break;

                case 6:
                    System.out.print("ID del libro a prestar: ");
                    String borrowBookId = scanner.nextLine();
                    controller.borrowBook(borrowBookId);
                    break;

                case 7:
                    System.out.print("ID del libro a devolver: ");
                    String returnBookId = scanner.nextLine();
                    controller.returnBook(returnBookId);
                    break;

                case 8:
                    System.out.print("ID de la revista a prestar: ");
                    int borrowMagId = scanner.nextInt();
                    controller.borrowMagazine(borrowMagId);
                    break;

                case 9:
                    controller.showStatistics();
                    break;

                case 10:
                    view.displayMessage("Saliendo del sistema de biblioteca...");
                    break;

                default:
                    view.displayMessage("Opción no válida!");
            }

        } while (option != 10);

        scanner.close();
    }
}