package util;

import model.Book;
import model.Student;
import model.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {


    // =====================================================
    // BOOK METHODS
    // =====================================================

    // Save books to books.txt
    public static void saveBooks(ArrayList<Book> books) {

        try {

            FileWriter writer =
                    new FileWriter("books.txt");

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


    // Load books from books.txt
    public static ArrayList<Book> loadBooks() {

        ArrayList<Book> books =
                new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("books.txt")
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split(",");

                if (data.length == 4) {

                    int id =
                            Integer.parseInt(data[0]);

                    String title = data[1];

                    String author = data[2];

                    boolean issued =
                            Boolean.parseBoolean(data[3]);

                    Book book =
                            new Book(
                                    id,
                                    title,
                                    author
                            );

                    book.setIssued(issued);

                    books.add(book);
                }
            }

            reader.close();

        } catch (IOException e) {

            System.out.println(
                    "No book data found."
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid book data."
            );
        }

        return books;
    }


    // =====================================================
    // STUDENT METHODS
    // =====================================================

    // Save students to students.txt
    public static void saveStudents(
            ArrayList<Student> students) {

        try {

            FileWriter writer =
                    new FileWriter("students.txt");

            for (Student student : students) {

                writer.write(
                        student.getStudentId() + "," +
                                student.getName() + "," +
                                student.getCourse() + "\n"
                );
            }

            writer.close();

            System.out.println(
                    "Students saved successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error while saving students."
            );
        }
    }


    // Load students from students.txt
    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students =
                new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("students.txt")
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split(",");

                if (data.length == 3) {

                    int id =
                            Integer.parseInt(data[0]);

                    String name = data[1];

                    String course = data[2];

                    Student student =
                            new Student(
                                    id,
                                    name,
                                    course
                            );

                    students.add(student);
                }
            }

            reader.close();

        } catch (IOException e) {

            System.out.println(
                    "No student data found."
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid student data."
            );
        }

        return students;
    }


    // =====================================================
    // TRANSACTION METHODS
    // =====================================================

    // Save transactions to transactions.txt
    public static void saveTransactions(
            ArrayList<Transaction> transactions) {

        try {

            FileWriter writer =
                    new FileWriter(
                            "transactions.txt"
                    );

            for (Transaction transaction :
                    transactions) {

                writer.write(
                        transaction.getBookId() + "," +
                                transaction.getAction() + "," +
                                transaction.getTime() + "\n"
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


    // Load transactions from transactions.txt
    public static ArrayList<Transaction>
    loadTransactions() {

        ArrayList<Transaction> transactions =
                new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(
                                    "transactions.txt"
                            )
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split(",", 3);

                if (data.length == 3) {

                    int bookId =
                            Integer.parseInt(data[0]);

                    String action = data[1];

                    String time = data[2];

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

            System.out.println(
                    "No transaction data found."
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid transaction data."
            );
        }

        return transactions;
    }
}