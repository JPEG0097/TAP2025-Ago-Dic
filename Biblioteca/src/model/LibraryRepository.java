package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryRepository<T extends LibraryItem<?>> {
    private List<T> items;

    public LibraryRepository() {
        this.items = new ArrayList<>();
    }

    // Métodos genéricos para CRUD
    public void addItem(T item) {
        items.add(item);
    }

    public boolean removeItem(T item) {
        return items.remove(item);
    }

    public T getItemById(Object id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<T> getAllItems() {
        return new ArrayList<>(items);
    }

    public List<T> getAvailableItems() {
        return items.stream()
                .filter(LibraryItem::isAvailable)
                .collect(Collectors.toList());
    }

    public List<T> getBorrowedItems() {
        return items.stream()
                .filter(item -> !item.isAvailable())
                .collect(Collectors.toList());
    }

    public boolean borrowItem(Object id) {
        T item = getItemById(id);
        if (item != null && item.isAvailable()) {
            item.setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean returnItem(Object id) {
        T item = getItemById(id);
        if (item != null && !item.isAvailable()) {
            item.setAvailable(true);
            return true;
        }
        return false;
    }

    public int getTotalItems() {
        return items.size();
    }

    public int getAvailableItemsCount() {
        return (int) items.stream().filter(LibraryItem::isAvailable).count();
    }
}