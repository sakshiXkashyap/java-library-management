package service;

import model.Book;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Add Book
    public void addBook(Book book) {
        books.add(book);
    }

    // Display All Books
    public void displayAllBooks() {

        for (Book book : books) {
            book.displayBook();
        }

    }

    // Search Book
    public Book searchBookById(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {
                return book;
            }

        }

        return null;
    }

}