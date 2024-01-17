package library;

public class Book {
    private String title;
    private String author;
    private int quantity;
    private int borrowed;
    private String dueDate;
    private boolean reserved;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.borrowed = 0;
        this.dueDate = "";
        this.reserved = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getBorrowed() {
        return borrowed;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void borrow(int quantityToBorrow, String dueDate) {
        if (quantity - borrowed >= quantityToBorrow) {
            borrowed += quantityToBorrow;
            this.dueDate = dueDate;
            System.out.println(quantityToBorrow + " copies of \"" + title + "\" by " + author + " borrowed. Due date: " + dueDate);
        } else {
            System.out.println("Sorry, not enough copies available for \"" + title + "\".");
        }
    }

    public void returnBook(int quantityToReturn) {
        if (borrowed >= quantityToReturn) {
            borrowed -= quantityToReturn;
            System.out.println(quantityToReturn + " copies of \"" + title + "\" by " + author + " returned.");
        } else {
            System.out.println("Invalid return quantity for \"" + title + "\".");
        }
    }

    public void reserve() {
        reserved = true;
        System.out.println("A copy of \"" + title + "\" by " + author + " is reserved.");
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

