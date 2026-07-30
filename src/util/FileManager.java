package util;

import model.Book;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

}