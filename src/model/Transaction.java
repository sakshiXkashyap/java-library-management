
package model;

public class Transaction {

    private int bookId;
    private String action;
    private String time;


    // ==========================================
    // CONSTRUCTOR
    // ==========================================

    public Transaction(
            int bookId,
            String action,
            String time
    ) {

        this.bookId = bookId;
        this.action = action;
        this.time = time;
    }


    // ==========================================
    // GET BOOK ID
    // ==========================================

    public int getBookId() {

        return bookId;
    }


    // ==========================================
    // GET ACTION
    // ==========================================

    public String getAction() {

        return action;
    }


    // ==========================================
    // GET TIME
    // ==========================================

    public String getTime() {

        return time;
    }


    // ==========================================
    // DISPLAY TRANSACTION
    // ==========================================

    public void displayTransaction() {

        System.out.println(
                "Book ID: " + bookId +
                        " | Action: " + action +
                        " | Time: " + time
        );
    }
}