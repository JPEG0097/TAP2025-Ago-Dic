package model;

public class Book extends LibraryItem<String> {
    private String author;
    private String isbn;
    private int pages;

    public Book(String id, String title, int year, String author, String isbn, int pages) {
        super(id, title, year);
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    @Override
    public String getItemType() {
        return "Libro";
    }

    @Override
    public void displayInfo() {
        System.out.println("" + title + " por " + author +
                " (" + year + ") - " + (available ? "Disponible" : "Prestado"));
    }

    @Override
    public String toString() {
        return super.toString() + ", author='" + author + "', isbn='" + isbn + "', pages=" + pages + "}";
    }
}