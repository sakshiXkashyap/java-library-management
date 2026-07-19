import model.Book;
import service.Library;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== LIBRARY MANAGEMENT SYSTEM =====");

        Library library = new Library();

        library.addBook(new Book(
                101,
                "Java Programming",
                "James Gosling"
        ));

        library.addBook(new Book(
                102,
                "Clean Code",
                "Robert C. Martin"
        ));

        library.addBook(new Book(
                103,
                "Effective Java",
                "Joshua Bloch"
        ));

        library.displayAllBooks();

    }

}