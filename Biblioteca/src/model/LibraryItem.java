package model;

public abstract class LibraryItem<T> {
    protected T id;
    protected String title;
    protected int year;
    protected boolean available;

    public LibraryItem(T id, String title, int year) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.available = true;
    }

    // Getters y Setters
    public T getId() { return id; }
    public void setId(T id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public abstract String getItemType();
    public abstract void displayInfo();

    @Override
    public String toString() {
        return getItemType() + "{id=" + id + ", title='" + title +
                "', year=" + year + ", available=" + available + "}";
    }
}