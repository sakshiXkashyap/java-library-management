package service;

import model.Book;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayAllBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n===== Library Books =====");

        for (Book book : books) {
            book.displayBook();
        }

    }

}
