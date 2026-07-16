import java.util.Scanner;

public class Main {

    // Method to display welcome message
    public static void welcomeMessage() {
        System.out.println("==================================");
        System.out.println("   LIBRARY MANAGEMENT SYSTEM");
        System.out.println("==================================");
    }

    // Method to calculate late fee
    public static double calculateLateFee(int daysLate) {
        double feePerDay = 5.0;
        return daysLate * feePerDay;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        welcomeMessage();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();

        System.out.print("Enter number of late days: ");
        int daysLate = scanner.nextInt();

        double totalFee = calculateLateFee(daysLate);

        System.out.println("\n========= Receipt =========");
        System.out.println("Student Name : " + name);
        System.out.println("Book ID      : " + bookId);
        System.out.println("Late Days    : " + daysLate);
        System.out.println("Late Fee     : ₹" + totalFee);

        if (daysLate == 0) {
            System.out.println("Status       : Returned On Time");
        } else {
            System.out.println("Status       : Late Return");
        }

        scanner.close();
    }
}