import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Library Management System =====");

        System.out.print("Enter your full name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.println();

        System.out.println("Welcome " + name + "!");
        System.out.println("Age : " + age);

        scanner.close();
    }
}