package model;

public class Client implements Identifiable<Integer> {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private double balance;

    public Client(Integer id, String name, String email, String phone, double balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    @Override
    public String toString() {
        return String.format("%-3d %-20s %-20s %-15s $%.2f", id, name, email, phone, balance);
    }
}