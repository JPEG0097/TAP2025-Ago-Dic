package inventory.model;

import java.time.LocalDate;

public class Product implements Identifiable<String> {
    private String code;
    private String name;
    private double price;
    private int quantity;
    private String category;
    private LocalDate expiryDate;

    public Product(String code, String name, double price, int quantity, String category, LocalDate expiryDate) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.expiryDate = expiryDate;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    @Override
    public String toString() {
        return String.format("%-7s %-20s %.2f\t%-10d %-15s %s",
                code, name, price, quantity, category, expiryDate != null ? expiryDate.toString() : "N/A");
    }

    @Override
    public String getId() {
        return code;
    }
}