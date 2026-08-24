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

        books = FileManager.loadBooks();

        if (books == null) {

            books = new ArrayList<>();
        }

        students = new ArrayList<>();

        transactions =
                FileManager.loadTransactions();

        if (transactions == null) {

            transactions = new ArrayList<>();
        }

        System.out.println(
                "Books loaded successfully."
        );

        System.out.println(
                "Transactions loaded: " +
                        transactions.size()
        );
    }


    // =====================================================
    // ADD DEFAULT BOOK
    // =====================================================

    public void addBook(Book book) {

        books.add(book);

        FileManager.saveBooks(books);
    }


    // =====================================================
    // ADD NEW BOOK
    // =====================================================

    public boolean addNewBook(Book book) {

        if (searchBookById(
                book.getBookId()
        ) != null) {

            return false;
        }

        books.add(book);

        FileManager.saveBooks(books);

        return true;
    }


    // =====================================================
    // DISPLAY ALL BOOKS
    // =====================================================

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


    // =====================================================
    // SEARCH BOOK
    // =====================================================

    public Book searchBookById(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {

                return book;
            }
        }

        return null;
    }


    // =====================================================
    // DELETE BOOK
    // =====================================================

    public void deleteBook(int bookId) {

        Book book =
                searchBookById(bookId);

        if (book == null) {

            System.out.println(
                    "Book not found."
            );

            return;
        }

        books.remove(book);

        FileManager.saveBooks(books);

        System.out.println(
                "Book deleted successfully."
        );
    }


    // =====================================================
    // SHOW TOTAL BOOKS
    // =====================================================

    public void showTotalBooks() {

        System.out.println(
                "\nTotal Books: " +
                        books.size()
        );
    }


    // =====================================================
    // SHOW AVAILABLE BOOKS
    // =====================================================

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
    // ADD STUDENT
    // =====================================================

    public void addStudent(Student student) {

        students.add(student);
    }


    // =====================================================
    // SEARCH STUDENT
    // =====================================================

    public Student searchStudentById(
            int studentId
    ) {

        for (Student student : students) {

            if (student.getStudentId() ==
                    studentId) {

                return student;
            }
        }

        return null;
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

        Book book =
                searchBookById(bookId);

        if (book == null) {

            throw new BookNotFoundException(
                    "Book with ID " +
                            bookId +
                            " was not found."
            );
        }


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


        if (book.isIssued()) {

            throw new BookAlreadyIssuedException(
                    "Book with ID " +
                            bookId +
                            " is already issued."
            );
        }


        // Mark book as issued
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


        // Save book
        FileManager.saveBooks(books);


        // Save transaction
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

        Book book =
                searchBookById(bookId);

        if (book == null) {

            System.out.println(
                    "Book not found."
            );

            return;
        }


        if (!book.isIssued()) {

            System.out.println(
                    "This book is not currently issued."
            );

            return;
        }


        // Mark book available
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


        // Save book
        FileManager.saveBooks(books);


        // Save transaction
        FileManager.saveTransactions(
                transactions
        );


        System.out.println(
                "Book returned successfully."
        );
    }


    // =====================================================
    // TRANSACTION HISTORY
    // =====================================================

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


    // =====================================================
    // TOTAL TRANSACTIONS
    // =====================================================

    public void showTotalTransactions() {

        System.out.println(
                "\nTotal Transactions: " +
                        transactions.size()
        );
    }

    // ==========================================
// STUDENT MANAGEMENT
// ==========================================

    // Add new student with duplicate ID checking
    public boolean addNewStudent(Student student) {

        if (searchStudentById(student.getStudentId()) != null) {
            return false;
        }

        students.add(student);

        return true;
    }


    // Display all students
    public void displayAllStudents() {

        System.out.println("\n========== ALL STUDENTS ==========");

        if (students.isEmpty()) {

            System.out.println("No students available.");
            return;
        }

        for (Student student : students) {

            System.out.println(
                    "Student ID : " + student.getStudentId()
            );

            System.out.println(
                    "Name       : " + student.getName()
            );

            System.out.println(
                    "Course     : " + student.getCourse()
            );

            System.out.println("----------------------------------");
        }
    }


    // Delete student
    public void deleteStudent(int studentId) {

        Student student = searchStudentById(studentId);

        if (student == null) {

            System.out.println("Student not found.");
            return;
        }

        students.remove(student);

        System.out.println("Student deleted successfully.");
    }
}