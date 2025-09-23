package model;

import java.time.LocalDate;

public class Sale implements Identifiable<Integer> {
    private Integer id;
    private String productCode;
    private int quantity;
    private double price; // unit price at sale
    private LocalDate date;
    private int clientId;

    public Sale(Integer id, String productCode, int quantity, double price, LocalDate date, int clientId) {
        this.id = id;
        this.productCode = productCode;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.clientId = clientId;
    }

    public Integer getId() { return id; }
    public String getProductCode() { return productCode; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public LocalDate getDate() { return date; }
    public int getClientId() { return clientId; }
}