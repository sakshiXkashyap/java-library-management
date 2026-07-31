import model.Book;
import service.Library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        // Default Books
        if (library.searchBookById(101) == null) {

            library.addBook(new Book(101, "Java Programming", "James Gosling"));
            library.addBook(new Book(102, "Clean Code", "Robert C. Martin"));
            library.addBook(new Book(103, "Effective Java", "Joshua Bloch"));

        }

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n========== LIBRARY MENU ==========");
            System.out.println("1. View All Books");
            System.out.println("2. Search Book");
            System.out.println("3. Add New Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Show Total Books");
            System.out.println("8. Exit");

            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    library.displayAllBooks();
                    break;

                case 2:

                    System.out.print("Enter Book ID: ");
                    int searchId = scanner.nextInt();

                    Book foundBook = library.searchBookById(searchId);

                    if (foundBook != null) {

                        System.out.println("\nBook Found:");
                        foundBook.displayBook();

                    } else {

                        System.out.println("Book Not Found.");
                    }

                    break;

                case 3:

                    scanner.nextLine(); // Clear buffer

                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();

                    Book newBook = new Book(id, title, author);

                    if (library.addNewBook(newBook)) {

                        System.out.println("Book added successfully.");

                    } else {

                        System.out.println("Book ID already exists.");

                    }

                    break;

                case 4:

                    System.out.print("Enter Book ID: ");
                    int issueId = scanner.nextInt();

                    library.issueBook(issueId);

                    break;

                case 5:

                    System.out.print("Enter Book ID: ");
                    int returnId = scanner.nextInt();

                    library.returnBook(returnId);

                    break;

                case 6:

                    System.out.print("Enter Book ID: ");
                    int deleteId = scanner.nextInt();

                    if (library.deleteBook(deleteId)) {

                        System.out.println("Book deleted successfully.");

                    } else {

                        System.out.println("Book could not be deleted.");

                    }

                    break;

                case 7:

                    library.showTotalBooks();

                    break;

                case 8:

                    library.saveLibrary();

                    break;

                case 9:

                    System.out.println("Thank you for using Library Management System.");

                    break;

                default:

                    System.out.println("Invalid Choice. Please try again.");
            }

        } while (choice != 9);

        scanner.close();
    }
}