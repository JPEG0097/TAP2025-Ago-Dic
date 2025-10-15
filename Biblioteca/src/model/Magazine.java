package model;

public class Magazine extends LibraryItem<Integer> {
    private String publisher;
    private int issueNumber;
    private String category;

    public Magazine(Integer id, String title, int year, String publisher, int issueNumber, String category) {
        super(id, title, year);
        this.publisher = publisher;
        this.issueNumber = issueNumber;
        this.category = category;
    }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public int getIssueNumber() { return issueNumber; }
    public void setIssueNumber(int issueNumber) { this.issueNumber = issueNumber; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    @Override
    public String getItemType() {
        return "Revista";
    }

    @Override
    public void displayInfo() {
        System.out.println(" " + title + " - Edición " + issueNumber +
                " (" + year + ") - " + (available ? "Disponible" : "Prestado"));
    }

    @Override
    public String toString() {
        return super.toString() + ", publisher='" + publisher +
                "', issueNumber=" + issueNumber + ", category='" + category + "'}";
    }
}