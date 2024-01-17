package library;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<String, Book> books;

    public LibrarySystem() {
        books = new HashMap<>();
    }

    public void addBook(String title, String author, int quantity) {
        if (books.containsKey(title)) {
            Book existingBook = books.get(title);
            existingBook.reserve();
            existingBook.setQuantity(existingBook.getQuantity() + quantity);
        } else {
            Book newBook = new Book(title, author, quantity);
            books.put(title, newBook);
        }
    }

    public void borrowBook(String title, int quantityToBorrow, String dueDate) {
        if (books.containsKey(title)) {
            Book book = books.get(title);
            book.borrow(quantityToBorrow, dueDate);
        } else {
            System.out.println("The book \"" + title + "\" is not available in the library.");
        }
    }

    public void returnBook(String title, int quantityToReturn) {
        if (books.containsKey(title)) {
            Book book = books.get(title);
            book.returnBook(quantityToReturn);
        } else {
            System.out.println("The book \"" + title + "\" is not part of our library collection.");
        }
    }

    public void displayLibrary() {
        System.out.println("Library Catalog:");
        for (Book book : books.values()) {
            System.out.println("Title: \"" + book.getTitle() + "\", Author: " + book.getAuthor() + ", Quantity: " +
                    book.getQuantity() + ", Borrowed: " + book.getBorrowed() + ", Due Date: " +
                    book.getDueDate() + ", Reserved: " + book.isReserved());
        }
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        // Adding books to the library
        library.addBook("Java Programming", "John Doe", 5);
        library.addBook("Python for Beginners", "Jane Smith", 3);
        library.addBook("Data Structures and Algorithms", "Alice Johnson", 10);

        // Borrowing and returning books
        library.borrowBook("Java Programming", 2, "2023-10-15");
        library.borrowBook("Python for Beginners", 5, "2023-10-20"); // Not enough copies
        library.returnBook("Java Programming", 1);
        library.returnBook("C++ Programming", 3); // Book not in library

        // Displaying the library catalog
        library.displayLibrary();
    }
}

