package util;

import model.Book;
import model.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {


    // =====================================================
    // BOOK FILE
    // =====================================================

    private static final String BOOK_FILE =
            "books.txt";


    // =====================================================
    // TRANSACTION FILE
    // =====================================================

    private static final String TRANSACTION_FILE =
            "transactions.txt";


    // =====================================================
    // SAVE BOOKS
    // =====================================================

    public static void saveBooks(ArrayList<Book> books) {

        try {

            FileWriter writer =
                    new FileWriter(BOOK_FILE);

            for (Book book : books) {

                writer.write(
                        book.getBookId() + "," +
                                book.getTitle() + "," +
                                book.getAuthor() + "," +
                                book.isIssued() + "\n"
                );
            }

            writer.close();

            System.out.println(
                    "Books saved successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error while saving books."
            );
        }
    }


    // =====================================================
    // LOAD BOOKS
    // =====================================================

    public static ArrayList<Book> loadBooks() {

        ArrayList<Book> books =
                new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(BOOK_FILE)
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split(",", 4);

                if (data.length == 4) {

                    int bookId =
                            Integer.parseInt(data[0]);

                    String title =
                            data[1];

                    String author =
                            data[2];

                    boolean issued =
                            Boolean.parseBoolean(data[3]);

                    Book book =
                            new Book(
                                    bookId,
                                    title,
                                    author
                            );

                    book.setIssued(issued);

                    books.add(book);
                }
            }

            reader.close();

        } catch (IOException e) {

            // File doesn't exist yet.
        }

        return books;
    }


    // =====================================================
    // SAVE TRANSACTIONS
    // =====================================================

    public static void saveTransactions(
            ArrayList<Transaction> transactions
    ) {

        try {

            FileWriter writer =
                    new FileWriter(TRANSACTION_FILE);

            for (Transaction transaction :
                    transactions) {

                writer.write(
                        transaction.getBookId() +
                                "," +
                                transaction.getAction() +
                                "," +
                                transaction.getTime() +
                                "\n"
                );
            }

            writer.close();

            System.out.println(
                    "Transactions saved successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error while saving transactions."
            );
        }
    }


    // =====================================================
    // LOAD TRANSACTIONS
    // =====================================================

    public static ArrayList<Transaction>
    loadTransactions() {

        ArrayList<Transaction> transactions =
                new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(
                                    TRANSACTION_FILE
                            )
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split(",", 3);

                if (data.length == 3) {

                    int bookId =
                            Integer.parseInt(data[0]);

                    String action =
                            data[1];

                    String time =
                            data[2];

                    Transaction transaction =
                            new Transaction(
                                    bookId,
                                    action,
                                    time
                            );

                    transactions.add(transaction);
                }
            }

            reader.close();

        } catch (IOException e) {

            // File doesn't exist yet.
        }

        return transactions;
    }
}