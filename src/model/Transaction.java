package model;

public class Transaction {

    private int bookId;
    private String action;
    private String time;

    public Transaction(int bookId, String action, String time) {

        this.bookId = bookId;
        this.action = action;
        this.time = time;
    }

    public int getBookId() {
        return bookId;
    }

    public String getAction() {
        return action;
    }

    public String getTime() {
        return time;
    }

    public void displayTransaction() {

        System.out.println(
                "Book ID: " + bookId +
                        " | Action: " + action +
                        " | Time: " + time
        );
    }
}