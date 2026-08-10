package model;

public class Transaction {

    private int bookId;
    private String action;
    private String dateTime;

    public Transaction(int bookId, String action, String dateTime) {
        this.bookId = bookId;
        this.action = action;
        this.dateTime = dateTime;
    }

    public int getBookId() {
        return bookId;
    }

    public String getAction() {
        return action;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void displayTransaction() {

        System.out.println(
                "Book ID: " + bookId +
                        " | Action: " + action +
                        " | Time: " + dateTime
        );
    }
}