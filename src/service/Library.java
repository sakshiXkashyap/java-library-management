package service;

import excaption.BookAlreadyIssuedException;
import excaption.BookNotFoundException;
import model.Book;
import model.Transaction;
import util.FileManager;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Transaction> transactions;

    // Constructor
    public Library() {
        books = FileManager.loadBooks();
        transactions = new ArrayList<>();
    }

    // Add default book
    public void addBook(Book book) {
        books.add(book);
    }

    // Display all books
    public void displayAllBooks() {

        System.out.println("\n===== Library Books =====");

        for (Book book : books) {
            book.displayBook();
        }
    }

    // Search book
    public Book searchBookById(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {
                return book;
            }
        }

        return null;
    }

    // Issue book
    public void issueBook(int bookId) throws BookNotFoundException,
            BookAlreadyIssuedException {

        Book book = searchBookById(bookId);

        if (book == null) {
            throw new BookNotFoundException("Book with ID "
                    + bookId + " not found.");
        }

        if (book.isIssued()) {
            throw new BookAlreadyIssuedException(
                    "Book is already issued."
            );
        }

        book.setIssued(true);

        transactions.add(
                new Transaction(
                        bookId,
                        "ISSUED",
                        LocalDateTime.now().toString()
                )
        );

        FileManager.saveBooks(books);

        System.out.println("Book issued successfully.");
    }

    // Return book
    public void returnBook(int bookId) throws BookNotFoundException {

        Book book = searchBookById(bookId);

        if (book == null) {
            throw new BookNotFoundException(
                    "Book with ID " + bookId + " not found."
            );
        }

        if (!book.isIssued()) {
            System.out.println("This book was not issued.");
            return;
        }

        book.setIssued(false);

        transactions.add(
                new Transaction(
                        bookId,
                        "RETURNED",
                        LocalDateTime.now().toString()
                )
        );

        FileManager.saveBooks(books);

        System.out.println("Book returned successfully.");
    }

    // Display transaction history
    public void displayTransactionHistory() {

        System.out.println("\n===== TRANSACTION HISTORY =====");

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    // Add a new book
    public boolean addNewBook(Book book) {

        if (searchBookById(book.getBookId()) != null) {
            return false;
        }

        books.add(book);
        FileManager.saveBooks(books);

        return true;
    }


    // Delete a book
    public boolean deleteBook(int bookId) {

        Book book = searchBookById(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }

        books.remove(book);

        FileManager.saveBooks(books);

        System.out.println("Book deleted successfully.");

        return true;
    }


    // Show total books
    public void showTotalBooks() {

        System.out.println("Total Books: " + books.size());
    }
}
