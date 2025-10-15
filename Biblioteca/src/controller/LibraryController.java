package controller;

import model.Book;
import model.Magazine;
import model.LibraryRepository;
import factory.LibraryItemFactory;
import view.LibraryView;

public class LibraryController {
    private LibraryRepository<Book> bookRepository;
    private LibraryRepository<Magazine> magazineRepository;
    private LibraryView view;

    public LibraryController(LibraryRepository<Book> bookRepository,
                             LibraryRepository<Magazine> magazineRepository,
                             LibraryView view) {
        this.bookRepository = bookRepository;
        this.magazineRepository = magazineRepository;
        this.view = view;
    }

    // Métodos para Libros
    public void addBook(Book book) {
        bookRepository.addItem(book);
        view.displayMessage("Libro agregado exitosamente!");
    }

    public void addNovel(String id, String title, int year, String author, String isbn, int pages) {
        Book novel = LibraryItemFactory.createNovel(id, title, year, author, isbn, pages);
        addBook(novel);
    }

    public void addTextbook(String id, String title, int year, String author, String isbn, int pages) {
        Book textbook = LibraryItemFactory.createTextbook(id, title, year, author, isbn, pages);
        addBook(textbook);
    }

    // Métodos para Revistas
    public void addMagazine(Magazine magazine) {
        magazineRepository.addItem(magazine);
        view.displayMessage("Revista agregada exitosamente!");
    }

    public void addScienceMagazine(int id, String title, int year, String publisher, int issueNumber) {
        Magazine magazine = LibraryItemFactory.createScienceMagazine(id, title, year, publisher, issueNumber);
        addMagazine(magazine);
    }

    // Operaciones comunes
    public void showAllItems() {
        view.displayAllItems(bookRepository.getAllItems(), magazineRepository.getAllItems());
    }

    public void showAvailableItems() {
        view.displayAvailableItems(bookRepository.getAvailableItems(), magazineRepository.getAvailableItems());
    }

    public boolean borrowBook(String bookId) {
        boolean success = bookRepository.borrowItem(bookId);
        if (success) {
            view.displayMessage("Libro prestado exitosamente!");
        } else {
            view.displayMessage("No se pudo prestar el libro. Verifique la disponibilidad.");
        }
        return success;
    }

    public boolean returnBook(String bookId) {
        boolean success = bookRepository.returnItem(bookId);
        if (success) {
            view.displayMessage("Libro devuelto exitosamente!");
        } else {
            view.displayMessage("No se pudo devolver el libro.");
        }
        return success;
    }

    public boolean borrowMagazine(int magazineId) {
        boolean success = magazineRepository.borrowItem(magazineId);
        if (success) {
            view.displayMessage("Revista prestada exitosamente!");
        } else {
            view.displayMessage("No se pudo prestar la revista. Verifique la disponibilidad.");
        }
        return success;
    }

    public void showStatistics() {
        int totalBooks = bookRepository.getTotalItems();
        int availableBooks = bookRepository.getAvailableItemsCount();
        int totalMagazines = magazineRepository.getTotalItems();
        int availableMagazines = magazineRepository.getAvailableItemsCount();

        view.displayStatistics(totalBooks, availableBooks, totalMagazines, availableMagazines);
    }
}