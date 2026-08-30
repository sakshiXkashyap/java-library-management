import excaption.BookAlreadyIssuedException;
import excaption.BookNotFoundException;
import model.Book;
import model.Student;
import service.Library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n======================================");
        System.out.println("     LIBRARY MANAGEMENT SYSTEM");
        System.out.println("======================================");

        Library library = new Library();

        // ==========================================
        // DEFAULT BOOKS
        // ==========================================

        if (library.searchBookById(101) == null) {
            library.addBook(
                    new Book(
                            101,
                            "Java Programming",
                            "James Gosling"
                    )
            );
        }

        if (library.searchBookById(102) == null) {
            library.addBook(
                    new Book(
                            102,
                            "Clean Code",
                            "Robert C. Martin"
                    )
            );
        }

        if (library.searchBookById(103) == null) {
            library.addBook(
                    new Book(
                            103,
                            "Effective Java",
                            "Joshua Bloch"
                    )
            );
        }

        // ==========================================
        // DEFAULT STUDENTS
        // ==========================================

        if (library.searchStudentById(201) == null) {
            library.addStudent(
                    new Student(
                            201,
                            "Sakshi",
                            "MCA"
                    )
            );
        }

        if (library.searchStudentById(202) == null) {
            library.addStudent(
                    new Student(
                            202,
                            "Rahul",
                            "BCA"
                    )
            );
        }

        if (library.searchStudentById(203) == null) {
            library.addStudent(
                    new Student(
                            203,
                            "Priya",
                            "B.Tech"
                    )
            );
        }

        Scanner scanner = new Scanner(System.in);

        int choice;

        // ==========================================
        // MAIN MENU
        // ==========================================

        do {

            System.out.println("\n========== LIBRARY MENU ==========");

            System.out.println("1. View All Books");
            System.out.println("2. Search Book");
            System.out.println("3. Add New Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Show Available Books");
            System.out.println("8. Show Total Books");
            System.out.println("9. Transaction History");
            System.out.println("10. Show Total Transactions");
            System.out.println("11. View All Students");
            System.out.println("12. Add New Student");
            System.out.println("13. Search Student");
            System.out.println("14. Delete Student");
            System.out.println("15. Exit");

            choice = readInteger(
                    scanner,
                    "\nEnter your choice: "
            );

            switch (choice) {

                // ==================================
                // 1. VIEW ALL BOOKS
                // ==================================

                case 1:

                    library.displayAllBooks();

                    break;

                // ==================================
                // 2. SEARCH BOOK
                // ==================================

                case 2:

                    int searchId = readInteger(
                            scanner,
                            "Enter Book ID: "
                    );

                    Book foundBook =
                            library.searchBookById(searchId);

                    if (foundBook != null) {

                        System.out.println("\nBook Found:");

                        foundBook.displayBook();

                    } else {

                        System.out.println(
                                "Book Not Found."
                        );
                    }

                    break;

                // ==================================
                // 3. ADD NEW BOOK
                // ==================================

                case 3:

                    int id = readInteger(
                            scanner,
                            "Enter Book ID: "
                    );

                    System.out.print(
                            "Enter Book Title: "
                    );

                    String title =
                            scanner.nextLine();

                    System.out.print(
                            "Enter Author Name: "
                    );

                    String author =
                            scanner.nextLine();

                    Book newBook =
                            new Book(
                                    id,
                                    title,
                                    author
                            );

                    if (library.addNewBook(newBook)) {

                        System.out.println(
                                "Book added successfully."
                        );

                    } else {

                        System.out.println(
                                "Book ID already exists."
                        );
                    }

                    break;

                // ==================================
                // 4. ISSUE BOOK
                // ==================================

                case 4:

                    int issueId = readInteger(
                            scanner,
                            "Enter Book ID: "
                    );

                    int studentId = readInteger(
                            scanner,
                            "Enter Student ID: "
                    );

                    try {

                        library.issueBook(
                                issueId,
                                studentId
                        );

                    } catch (BookNotFoundException e) {

                        System.out.println(
                                "Error: " +
                                        e.getMessage()
                        );

                    } catch (
                            BookAlreadyIssuedException e
                    ) {

                        System.out.println(
                                "Error: " +
                                        e.getMessage()
                        );
                    }

                    break;

                // ==================================
                // 5. RETURN BOOK
                // ==================================

                case 5:

                    int returnId = readInteger(
                            scanner,
                            "Enter Book ID: "
                    );

                    library.returnBook(returnId);

                    break;

                // ==================================
                // 6. DELETE BOOK
                // ==================================

                case 6:

                    int deleteId = readInteger(
                            scanner,
                            "Enter Book ID: "
                    );

                    library.deleteBook(deleteId);

                    break;

                // ==================================
                // 7. AVAILABLE BOOKS
                // ==================================

                case 7:

                    library.showAvailableBooks();

                    break;

                // ==================================
                // 8. TOTAL BOOKS
                // ==================================

                case 8:

                    library.showTotalBooks();

                    break;

                // ==================================
                // 9. TRANSACTION HISTORY
                // ==================================

                case 9:

                    library.displayTransactionHistory();

                    break;

                // ==================================
                // 10. TOTAL TRANSACTIONS
                // ==================================

                case 10:

                    library.showTotalTransactions();

                    break;

                // ==================================
                // 11. VIEW ALL STUDENTS
                // ==================================

                case 11:

                    library.displayAllStudents();

                    break;

                // ==================================
                // 12. ADD NEW STUDENT
                // ==================================

                case 12:

                    int newStudentId = readInteger(
                            scanner,
                            "Enter Student ID: "
                    );

                    System.out.print(
                            "Enter Student Name: "
                    );

                    String studentName =
                            scanner.nextLine();

                    System.out.print(
                            "Enter Course: "
                    );

                    String course =
                            scanner.nextLine();

                    Student newStudent =
                            new Student(
                                    newStudentId,
                                    studentName,
                                    course
                            );

                    if (
                            library.addNewStudent(
                                    newStudent
                            )
                    ) {

                        System.out.println(
                                "Student added successfully."
                        );

                    } else {

                        System.out.println(
                                "Student ID already exists."
                        );
                    }

                    break;

                // ==================================
                // 13. SEARCH STUDENT
                // ==================================

                case 13:

                    int searchStudentId =
                            readInteger(
                                    scanner,
                                    "Enter Student ID: "
                            );

                    Student foundStudent =
                            library.searchStudentById(
                                    searchStudentId
                            );

                    if (foundStudent != null) {

                        System.out.println(
                                "\nStudent Found:"
                        );

                        foundStudent.displayStudent();

                    } else {

                        System.out.println(
                                "Student Not Found."
                        );
                    }

                    break;

                // ==================================
                // 14. DELETE STUDENT
                // ==================================

                case 14:

                    int deleteStudentId =
                            readInteger(
                                    scanner,
                                    "Enter Student ID: "
                            );

                    if (
                            library.deleteStudent(
                                    deleteStudentId
                            )
                    ) {

                        System.out.println(
                                "Student deleted successfully."
                        );

                    } else {

                        System.out.println(
                                "Student Not Found."
                        );
                    }

                    break;

                // ==================================
                // 15. EXIT
                // ==================================

                case 15:

                    System.out.println(
                            "\nThank you for using " +
                                    "Library Management System."
                    );

                    break;

                // ==================================
                // INVALID CHOICE
                // ==================================

                default:

                    System.out.println(
                            "Invalid Choice. " +
                                    "Please try again."
                    );
            }

        } while (choice != 15);

        scanner.close();
    }


    // ==============================================
    // SAFE INTEGER INPUT
    // ==============================================

    private static int readInteger(
            Scanner scanner,
            String message
    ) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. " +
                                "Please enter a number."
                );
            }
        }
    }
}