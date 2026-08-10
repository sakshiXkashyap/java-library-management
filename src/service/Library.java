package service;

import exception.BookNotFoundException;
import model.Book;
import util.FileManager;

import java.util.ArrayList;
import java.util.ArrayList;
import java.time.LocalDateTime;
import model.Transaction;

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

    // Add new book with duplicate ID validation
    public boolean addNewBook(Book book) {

        if (searchBookById(book.getBookId()) != null) {
            return false;
        }

        books.add(book);
        return true;
    }

    // Display all books
    public void displayAllBooks() {

        System.out.println("\n========== LIBRARY BOOKS ==========");

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            book.displayBook();
        }
    }

    // Search book by ID
    public Book searchBookById(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {
                return book;
            }
        }

        return null;
    }

    // Get book or throw custom exception
    public Book getBookOrThrow(int bookId) {

        Book book = searchBookById(bookId);

        if (book == null) {

            throw new BookNotFoundException(
                    "Book with ID " + bookId + " was not found."
            );
        }

        return book;
    }

    // Issue book
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

            transactions.add(
                    new Transaction(
                            bookId,
                            "ISSUED",
                            LocalDateTime.now().toString()
                    )
            );
        }
    }

    // Return book
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

            transactions.add(
                    new Transaction(
                            bookId,
                            "RETURNED",
                            LocalDateTime.now().toString()
                    )
            );
        }
    }

    // Delete book
    public boolean deleteBook(int bookId) {

        Book book = searchBookById(bookId);

        if (book == null) {

            System.out.println("Book not found.");
            return false;
        }

        if (book.isIssued()) {

            System.out.println("Cannot delete an issued book.");
            return false;
        }

        books.remove(book);

        return true;
    }

    // Show total books
    public void showTotalBooks() {

        System.out.println("Total Books : " + books.size());
    }

    // Save library data
    public void saveLibrary() {

        FileManager.saveBooks(books);
    }

    public void displayTransactionHistory() {

        System.out.println("\n========== TRANSACTION HISTORY ==========");

        if (transactions.isEmpty()) {

            System.out.println("No transactions found.");
            return;
        }

        for (Transaction transaction : transactions) {

            transaction.displayTransaction();
        }
    }
}