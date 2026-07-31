package util;
import model.Book;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class FileManager {

    public static void saveBooks(ArrayList<Book> books) {

        try {

            FileWriter writer = new FileWriter("books.txt");

            for (Book book : books) {

                writer.write(
                        book.getBookId() + "," +
                                book.getTitle() + "," +
                                book.getAuthor() + "," +
                                book.isIssued() + "\n"
                );

            }

            writer.close();

            System.out.println("Books saved successfully.");

        } catch (IOException e) {

            System.out.println("Error while saving books.");

        }

    }

    public static ArrayList<Book> loadBooks() {

        ArrayList<Book> books = new ArrayList<>();

        File file = new File("books.txt");

        if (!file.exists()) {
            return books;
        }

        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String title = data[1];
                String author = data[2];
                boolean issued = Boolean.parseBoolean(data[3]);

                Book book = new Book(id, title, author);
                book.setIssued(issued);

                books.add(book);

            }

            reader.close();

            System.out.println("Books loaded successfully.");

        } catch (IOException e) {

            e.printStackTrace();

        }

        return books;
    }

}