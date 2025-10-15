package factory;

import model.Book;
import model.Magazine;

public class LibraryItemFactory {

    // Factory methods para Libros
    public static Book createNovel(String id, String title, int year, String author, String isbn, int pages) {
        return new Book(id, title, year, author, isbn, pages);
    }

    public static Book createTextbook(String id, String title, int year, String author, String isbn, int pages) {
        return new Book(id, title, year, author, isbn, pages);
    }

    public static Book createScienceBook(String id, String title, int year, String author, String isbn, int pages) {
        return new Book(id, title, year, author, isbn, pages);
    }

    // Factory methods para Revistas
    public static Magazine createScienceMagazine(int id, String title, int year, String publisher, int issueNumber) {
        return new Magazine(id, title, year, publisher, issueNumber, "Ciencia");
    }

    public static Magazine createNewsMagazine(int id, String title, int year, String publisher, int issueNumber) {
        return new Magazine(id, title, year, publisher, issueNumber, "Noticias");
    }

    public static Magazine createEntertainmentMagazine(int id, String title, int year, String publisher, int issueNumber) {
        return new Magazine(id, title, year, publisher, issueNumber, "Entretenimiento");
    }

    public static Magazine createCustomMagazine(int id, String title, int year, String publisher, int issueNumber, String category) {
        return new Magazine(id, title, year, publisher, issueNumber, category);
    }
}