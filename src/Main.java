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

        library.addStudent(
                new Student(
                        201,
                        "Sakshi",
                        "MCA"
                )
        );

        library.addStudent(
                new Student(
                        202,
                        "Rahul",
                        "BCA"
                )
        );

        library.addStudent(
                new Student(
                        203,
                        "Priya",
                        "B.Tech"
                )
        );

        // ==========================================
        // SCANNER
        // ==========================================

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
            System.out.println("10. Exit");

            System.out.print("\nEnter your choice: ");

            choice = scanner.nextInt();

            // ==========================================
            // MENU OPTIONS
            // ==========================================

            switch (choice) {

                // --------------------------------------
                // 1. VIEW ALL BOOKS
                // --------------------------------------

                case 1:

                    library.displayAllBooks();

                    break;

                // --------------------------------------
                // 2. SEARCH BOOK
                // --------------------------------------

                case 2:

                    System.out.print("Enter Book ID: ");

                    int searchId = scanner.nextInt();

                    Book foundBook =
                            library.searchBookById(searchId);

                    if (foundBook != null) {

                        System.out.println("\nBook Found:");

                        foundBook.displayBook();

                    } else {

                        System.out.println("Book Not Found.");
                    }

                    break;

                // --------------------------------------
                // 3. ADD NEW BOOK
                // --------------------------------------

                case 3:

                    System.out.print("Enter Book ID: ");

                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Book Title: ");

                    String title = scanner.nextLine();

                    System.out.print("Enter Author Name: ");

                    String author = scanner.nextLine();

                    Book newBook =
                            new Book(id, title, author);

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

                // --------------------------------------
                // 4. ISSUE BOOK
                // --------------------------------------

                case 4:

                    System.out.print("Enter Book ID: ");

                    int issueId = scanner.nextInt();

                    System.out.print("Enter Student ID: ");

                    int studentId = scanner.nextInt();

                    try {

                        library.issueBook(
                                issueId,
                                studentId
                        );

                    } catch (BookNotFoundException e) {

                        System.out.println(
                                "Error: " + e.getMessage()
                        );

                    } catch (BookAlreadyIssuedException e) {

                        System.out.println(
                                "Error: " + e.getMessage()
                        );
                    }

                    break;

                // --------------------------------------
                // 5. RETURN BOOK
                // --------------------------------------

                case 5:

                    System.out.print("Enter Book ID: ");

                    int returnId = scanner.nextInt();

                    library.returnBook(returnId);

                    break;

                // --------------------------------------
                // 6. DELETE BOOK
                // --------------------------------------

                case 6:

                    System.out.print("Enter Book ID: ");

                    int deleteId = scanner.nextInt();

                    library.deleteBook(deleteId);

                    break;

                // --------------------------------------
                // 7. SHOW AVAILABLE BOOKS
                // --------------------------------------

                case 7:

                    library.showAvailableBooks();

                    break;

                // --------------------------------------
                // 8. SHOW TOTAL BOOKS
                // --------------------------------------

                case 8:

                    library.showTotalBooks();

                    break;

                // --------------------------------------
                // 9. TRANSACTION HISTORY
                // --------------------------------------

                case 9:

                    library.displayTransactionHistory();

                    break;

                // --------------------------------------
                // 10. EXIT
                // --------------------------------------

                case 10:

                    System.out.println(
                            "Thank you for using Library Management System."
                    );

                    break;

                // --------------------------------------
                // INVALID CHOICE
                // --------------------------------------

                default:

                    System.out.println(
                            "Invalid Choice. Please try again."
                    );
            }

        } while (choice != 10);

        // Close scanner
        scanner.close();
    }
}