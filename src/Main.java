import model.Book;
import service.Library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        library.addBook(new Book(101, "Java Programming", "James Gosling"));
        library.addBook(new Book(102, "Clean Code", "Robert C. Martin"));
        library.addBook(new Book(103, "Effective Java", "Joshua Bloch"));

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. View All Books");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
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

                    System.out.print("Enter Book ID: ");
                    int issueId = scanner.nextInt();

                    library.issueBook(issueId);

                    break;

                case 4:

                    System.out.println("Thank you for using Library Management System.");
                    break;

                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 4);

        scanner.close();
    }
}