package service;

import excaption.BookAlreadyIssuedException;
import excaption.BookNotFoundException;
import model.Book;
import model.Student;
import model.Transaction;
import util.FileManager;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Student> students;
    private ArrayList<Transaction> transactions;

    // Constructor
    public Library() {

        books = FileManager.loadBooks();

        if (books == null) {
            books = new ArrayList<>();
        }

        students = new ArrayList<>();
        transactions = new ArrayList<>();

        System.out.println("Books loaded successfully.");
    }

    // ==============================
    // BOOK METHODS
    // ==============================

    // Add default book
    public void addBook(Book book) {
        books.add(book);
    }

    // Add new book with duplicate ID checking
    public boolean addNewBook(Book book) {

        if (searchBookById(book.getBookId()) != null) {
            return false;
        }

        books.add(book);

        FileManager.saveBooks(books);

        return true;
    }

    // Display all books
    public void displayAllBooks() {

        System.out.println("\n========== ALL BOOKS ==========");

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

    // Delete book
    public void deleteBook(int bookId) {

        Book book = searchBookById(bookId);

        if (book == null) {

            System.out.println("Book not found.");
            return;
        }

        books.remove(book);

        FileManager.saveBooks(books);

        System.out.println("Book deleted successfully.");
    }

    // Show total books
    public void showTotalBooks() {

        System.out.println("\nTotal Books: " + books.size());
    }


    // ==============================
    // STUDENT METHODS
    // ==============================

    // Add student
    public void addStudent(Student student) {

        students.add(student);
    }

    // Search student by ID
    public Student searchStudentById(int studentId) {

        for (Student student : students) {

            if (student.getStudentId() == studentId) {
                return student;
            }
        }

        return null;
    }


    // ==============================
    // ISSUE BOOK
    // ==============================

    public void issueBook(int bookId, int studentId)
            throws BookNotFoundException, BookAlreadyIssuedException {

        Book book = searchBookById(bookId);

        // Check book
        if (book == null) {

            throw new BookNotFoundException(
                    "Book with ID " + bookId + " was not found."
            );
        }

        // Check student
        Student student = searchStudentById(studentId);

        if (student == null) {

            System.out.println(
                    "Student with ID " + studentId + " was not found."
            );

            return;
        }

        // Check whether book is already issued
        if (book.isIssued()) {

            throw new BookAlreadyIssuedException(
                    "Book with ID " + bookId + " is already issued."
            );
        }

        // Issue book
        book.setIssued(true);

        // Add transaction
        transactions.add(
                new Transaction(
                        bookId,
                        "ISSUED TO STUDENT " + studentId,
                        LocalDateTime.now().toString()
                )
        );

        // Save books
        FileManager.saveBooks(books);

        System.out.println("Book issued successfully.");
        System.out.println("Issued to: " + student.getName());
    }


    // ==============================
    // RETURN BOOK
    // ==============================

    public void returnBook(int bookId) {

        Book book = searchBookById(bookId);

        if (book == null) {

            System.out.println("Book not found.");
            return;
        }

        if (!book.isIssued()) {

            System.out.println("This book is not currently issued.");
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


    // ==============================
    // TRANSACTION HISTORY
    // ==============================

    public void displayTransactionHistory() {

        System.out.println("\n========== TRANSACTION HISTORY ==========");

        if (transactions.isEmpty()) {

            System.out.println("No transactions available.");
            return;
        }

        for (Transaction transaction : transactions) {

            transaction.displayTransaction();
        }
    }
}
