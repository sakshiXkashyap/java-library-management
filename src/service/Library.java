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


    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public Library() {

        // Load books
        books = FileManager.loadBooks();

        if (books == null) {
            books = new ArrayList<>();
        }


        // Load students
        students = FileManager.loadStudents();

        if (students == null) {
            students = new ArrayList<>();
        }


        // Load transactions
        transactions = FileManager.loadTransactions();

        if (transactions == null) {
            transactions = new ArrayList<>();
        }


        System.out.println("Books loaded successfully.");

        System.out.println(
                "Transactions loaded: " +
                        transactions.size()
        );
    }


    // =====================================================
    // BOOK MANAGEMENT
    // =====================================================

    // Add default book
    public void addBook(Book book) {

        books.add(book);
    }


    // Add new book
    public boolean addNewBook(Book book) {

        // Check duplicate Book ID
        if (searchBookById(book.getBookId()) != null) {

            return false;
        }

        books.add(book);

        FileManager.saveBooks(books);

        return true;
    }


    // Display all books
    public void displayAllBooks() {

        System.out.println(
                "\n========== ALL BOOKS =========="
        );

        if (books.isEmpty()) {

            System.out.println(
                    "No books available."
            );

            return;
        }

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


    // Delete book
    public void deleteBook(int bookId) {

        Book book =
                searchBookById(bookId);

        if (book == null) {

            System.out.println(
                    "Book not found."
            );

            return;
        }


        // Don't delete an issued book
        if (book.isIssued()) {

            System.out.println(
                    "Cannot delete an issued book."
            );

            return;
        }


        books.remove(book);

        FileManager.saveBooks(books);

        System.out.println(
                "Book deleted successfully."
        );
    }


    // Show total books
    public void showTotalBooks() {

        System.out.println(
                "\nTotal Books: " +
                        books.size()
        );
    }


    // Show available books
    public void showAvailableBooks() {

        System.out.println(
                "\n========== AVAILABLE BOOKS =========="
        );

        boolean availableBookFound = false;

        for (Book book : books) {

            if (!book.isIssued()) {

                book.displayBook();

                availableBookFound = true;
            }
        }


        if (!availableBookFound) {

            System.out.println(
                    "No books are currently available."
            );
        }
    }


    // =====================================================
    // STUDENT MANAGEMENT
    // =====================================================

    // Add student
    public void addStudent(Student student) {

        if (searchStudentById(
                student.getStudentId()
        ) == null) {

            students.add(student);

            FileManager.saveStudents(students);
        }
    }


    // Add new student
    public boolean addNewStudent(Student student) {

        // Check duplicate Student ID
        if (searchStudentById(
                student.getStudentId()
        ) != null) {

            return false;
        }


        students.add(student);

        FileManager.saveStudents(students);

        return true;
    }


    // Search student
    public Student searchStudentById(int studentId) {

        for (Student student : students) {

            if (student.getStudentId() == studentId) {

                return student;
            }
        }

        return null;
    }


    // Display all students
    public void displayAllStudents() {

        System.out.println(
                "\n========== ALL STUDENTS =========="
        );


        if (students.isEmpty()) {

            System.out.println(
                    "No students registered."
            );

            return;
        }


        for (Student student : students) {

            System.out.println(
                    "----------------------------"
            );

            student.displayStudent();
        }

        System.out.println(
                "----------------------------"
        );
    }


    // Delete student
    public boolean deleteStudent(int studentId) {

        Student student =
                searchStudentById(studentId);


        if (student == null) {

            return false;
        }


        students.remove(student);

        FileManager.saveStudents(students);

        return true;
    }


    // Show total students
    public void showTotalStudents() {

        System.out.println(
                "\nTotal Students: " +
                        students.size()
        );
    }


    // =====================================================
    // ISSUE BOOK
    // =====================================================

    public void issueBook(
            int bookId,
            int studentId
    )
            throws BookNotFoundException,
            BookAlreadyIssuedException {


        // Find book
        Book book =
                searchBookById(bookId);


        if (book == null) {

            throw new BookNotFoundException(
                    "Book with ID " +
                            bookId +
                            " was not found."
            );
        }


        // Find student
        Student student =
                searchStudentById(studentId);


        if (student == null) {

            System.out.println(
                    "Student with ID " +
                            studentId +
                            " was not found."
            );

            return;
        }


        // Check whether book is already issued
        if (book.isIssued()) {

            throw new BookAlreadyIssuedException(
                    "Book with ID " +
                            bookId +
                            " is already issued."
            );
        }


        // Issue book
        book.setIssued(true);


        // Create transaction
        Transaction transaction =
                new Transaction(
                        bookId,
                        "ISSUED TO STUDENT " +
                                studentId,
                        LocalDateTime.now().toString()
                );


        // Add transaction
        transactions.add(transaction);


        // Save books
        FileManager.saveBooks(books);


        // Save transactions
        FileManager.saveTransactions(
                transactions
        );


        System.out.println(
                "Book issued successfully."
        );

        System.out.println(
                "Issued to: " +
                        student.getName()
        );
    }


    // =====================================================
    // RETURN BOOK
    // =====================================================

    public void returnBook(int bookId) {

        // Find book
        Book book =
                searchBookById(bookId);


        if (book == null) {

            System.out.println(
                    "Book not found."
            );

            return;
        }


        // Check whether book is issued
        if (!book.isIssued()) {

            System.out.println(
                    "This book is not currently issued."
            );

            return;
        }


        // Return book
        book.setIssued(false);


        // Create transaction
        Transaction transaction =
                new Transaction(
                        bookId,
                        "RETURNED",
                        LocalDateTime.now().toString()
                );


        // Add transaction
        transactions.add(transaction);


        // Save books
        FileManager.saveBooks(books);


        // Save transactions
        FileManager.saveTransactions(
                transactions
        );


        System.out.println(
                "Book returned successfully."
        );
    }


    // =====================================================
    // TRANSACTION MANAGEMENT
    // =====================================================

    // Display transaction history
    public void displayTransactionHistory() {

        System.out.println(
                "\n========== TRANSACTION HISTORY =========="
        );


        if (transactions.isEmpty()) {

            System.out.println(
                    "No transactions available."
            );

            return;
        }


        for (Transaction transaction :
                transactions) {

            transaction.displayTransaction();
        }
    }


    // Show total transactions
    public void showTotalTransactions() {

        System.out.println(
                "\nTotal Transactions: " +
                        transactions.size()
        );
    }
}