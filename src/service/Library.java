package service;

import model.Book;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // Add Book
    public void addBook(Book book) {
        books.add(book);
    }

    // Display All Books
    public void displayAllBooks() {

        System.out.println("\n===== Library Books =====");

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            book.displayBook();
        }
    }

    // Search Book By ID
    public Book searchBookById(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {
                return book;
            }
        }

        return null;
    }

    // Issue Book
    public void issueBook(int bookId) {

        Book book = searchBookById(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isIssued()) {

            System.out.println("Book is already issued.");

        } else {

            book.setIssued(true);
            System.out.println("Book issued successfully.");

        }
    }

    // Return Book
    public void returnBook(int bookId) {

        Book book = searchBookById(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isIssued()) {

            System.out.println("This book was not issued.");

        } else {

            book.setIssued(false);
            System.out.println("Book returned successfully.");

        }
    }

    // Show Total Books
    public void showTotalBooks() {
        System.out.println("Total Books : " + books.size());
    }
}