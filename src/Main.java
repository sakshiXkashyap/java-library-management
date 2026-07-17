import model.Book;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== Library Management System =====");

        Book book1 = new Book(101, "Java Programming", "James Gosling");

        book1.displayBookDetails();

    }
}