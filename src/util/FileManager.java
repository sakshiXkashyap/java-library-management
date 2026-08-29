package util;

import model.Book;
import model.Student;
import model.Transaction;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String BOOK_FILE = "books.txt";
    private static final String TRANSACTION_FILE = "transactions.txt";
    private static final String STUDENT_FILE = "students.txt";


    // =====================================================
    // SAVE BOOKS
    // =====================================================

    public static void saveBooks(ArrayList<Book> books) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(BOOK_FILE)
                    );

            for (Book book : books) {

                writer.write(
                        book.getBookId() + "|" +
                                book.getTitle() + "|" +
                                book.getAuthor() + "|" +
                                book.isIssued()
                );

                writer.newLine();
            }

            writer.close();

            System.out.println("Books saved successfully.");

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

        File file = new File(BOOK_FILE);

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

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data =
                        line.split("\\|");

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

        } catch (Exception e) {

            System.out.println(
                    "Error while loading books."
            );
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

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(
                                    TRANSACTION_FILE
                            )
                    );

            for (Transaction transaction :
                    transactions) {

                writer.write(
                        transaction.getBookId() + "|" +
                                transaction.getAction() + "|" +
                                transaction.getTime()
                );

                writer.newLine();
            }

            writer.close();

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

        File file =
                new File(TRANSACTION_FILE);

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

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data =
                        line.split("\\|");

                if (data.length >= 3) {

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

        } catch (Exception e) {

            System.out.println(
                    "Error while loading transactions."
            );
        }

        return transactions;
    }


    // =====================================================
    // SAVE STUDENTS
    // =====================================================

    public static void saveStudents(
            ArrayList<Student> students
    ) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(
                                    STUDENT_FILE
                            )
                    );

            for (Student student :
                    students) {

                writer.write(
                        student.getStudentId() + "|" +
                                student.getName() + "|" +
                                student.getCourse()
                );

                writer.newLine();
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


    // =====================================================
    // LOAD STUDENTS
    // =====================================================

    public static ArrayList<Student>
    loadStudents() {

        ArrayList<Student> students =
                new ArrayList<>();

        File file =
                new File(STUDENT_FILE);

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

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data =
                        line.split("\\|");

                if (data.length >= 3) {

                    int studentId =
                            Integer.parseInt(data[0]);

                    String name = data[1];

                    String course = data[2];

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

        } catch (Exception e) {

            System.out.println(
                    "Error while loading students."
            );
        }

        return students;
    }
}