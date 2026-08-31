package util;

import model.Book;
import model.Student;
import model.Transaction;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    // =====================================================
    // BOOK METHODS
    // =====================================================

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


    public static ArrayList<Book> loadBooks() {

        ArrayList<Book> books =
                new ArrayList<>();

        File file = new File("books.txt");

        if (!file.exists()) {

            return books;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split(",");

                if (data.length >= 4) {

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

        } catch (IOException |
                 NumberFormatException e) {

            System.out.println(
                    "Error while loading books."
            );
        }

        return books;
    }


    // =====================================================
    // STUDENT METHODS
    // =====================================================

    public static void saveStudents(
            ArrayList<Student> students
    ) {

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


    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students =
                new ArrayList<>();

        File file =
                new File("students.txt");

        if (!file.exists()) {

            return students;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split(",");

                if (data.length >= 3) {

                    int studentId =
                            Integer.parseInt(data[0]);

                    String name =
                            data[1];

                    String course =
                            data[2];

                    Student student =
                            new Student(
                                    studentId,
                                    name,
                                    course
                            );

                    students.add(student);
                }
            }

            reader.close();

        } catch (IOException |
                 NumberFormatException e) {

            System.out.println(
                    "Error while loading students."
            );
        }

        return students;
    }


    // =====================================================
    // TRANSACTION METHODS
    // =====================================================

    public static void saveTransactions(
            ArrayList<Transaction> transactions
    ) {

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


    public static ArrayList<Transaction>
    loadTransactions() {

        ArrayList<Transaction> transactions =
                new ArrayList<>();

        File file =
                new File("transactions.txt");

        if (!file.exists()) {

            System.out.println(
                    "No transaction data found."
            );

            return transactions;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split(",", 3);

                if (data.length >= 3) {

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

                    transactions.add(
                            transaction
                    );
                }
            }

            reader.close();

        } catch (IOException |
                 NumberFormatException e) {

            System.out.println(
                    "Error while loading transactions."
            );
        }

        return transactions;
    }
}