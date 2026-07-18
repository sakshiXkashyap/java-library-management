import model.Book;
import model.Student;

public class Main {

    public static void main(String[] args) {

        Book book = new Book(101, "Java Programming", "James Gosling");

        Student student = new Student(
                1,
                "Sakshi Kashyap",
                "MCA"
        );

        System.out.println("===== Library Management System =====");

        book.displayBook();

        student.displayStudent();
    }
}