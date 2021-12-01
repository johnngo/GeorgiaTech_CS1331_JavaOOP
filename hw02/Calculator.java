import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation: ");
        String selection = input.nextLine();

        if (selection.toLowerCase().equals("alphabetize")) {
            System.out.println("Enter two words: ");
            String wd1 = input.next();
            String wd2 = input.next();

            if (wd2.toLowerCase().compareTo(wd1.toLowerCase()) < 0) {
                System.out.println("Answer: " + wd2 + " comes before " + wd1 + " alphabetically.");
            } else if (wd2.toLowerCase().compareTo(wd1.toLowerCase()) == 0) {
                System.out.println("Answer: Chicken or Egg.");
            } else {
                System.out.println("Answer: " + wd1 + " comes before " + wd2 + " alphabetically.");
            }
        } else if (selection.toLowerCase().equals("add") || selection.toLowerCase().equals("subtract")) {
            // System.out.println("Enter two integers:");
            // int num1 = input.nextInt();
            // int num2 = input.nextInt();
            int num1 = 0;
            int num2 = 0;

            switch (selection.toLowerCase()) {
                case "add":
                    System.out.println("Enter two integers:");
                    if (input.hasNextInt()) {
                        num1 = input.nextInt();
                    } else {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                    if (input.hasNextInt()) {
                        num2 = input.nextInt();
                    } else {
                        System.out.println("Invalid input entered. Terminating... ");
                        break;
                    }
                    System.out.printf("Answer: %d", (num1 + num2));
                    break;
                case "subtract":
                    System.out.println("Enter two integers:");
                    if (input.hasNextInt()) {
                        num1 = input.nextInt();
                    } else {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                    if (input.hasNextInt()) {
                        num2 = input.nextInt();
                    } else {
                        System.out.println("Invalid input entered. Terminating... ");
                        break;
                    }
                    System.out.printf("Answer: %d", (num1 - num2));
                    break;
                default:
                    System.out.println("Invalid input entered. Terminating...");
            }
        } else if (selection.toLowerCase().equals("multiply") || selection.toLowerCase().equals("divide")) {
            // System.out.println("Enter two doubles:");
            // double num1 = input.nextDouble();
            // double num2 = input.nextDouble();
            double num1 = 0;
            double num2 = 0;

            switch (selection.toLowerCase()) {
                case "multiply":
                    System.out.println("Enter two doubles: ");
                    if (input.hasNextDouble()) {
                        num1 = input.nextDouble();
                    } else {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                    if (input.hasNextDouble()) {
                        num2 = input.nextDouble();
                    } else {
                        System.out.println("Invalid input entered. Terminating... ");
                        break;
                    }
                    System.out.printf("Answer: %.2f", (num1 * num2));
                    break;
                case "divide":
                    System.out.println("Enter two doubles: ");
                    if (input.hasNextDouble()) {
                        num1 = input.nextDouble();
                    } else {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                    if (input.hasNextDouble()) {
                        num2 = input.nextDouble();
                        if (num2 == 0) {
                            System.out.println("Invalid input entered. Terminating...");
                            break;
                        }
                    } else {
                        System.out.println("Invalid input entered. Terminating... ");
                        break;
                    }
                    System.out.printf("Answer: %.2f", (num1 / num2));
                    break;

                default:
                    System.out.println("Invalid input entered. Terminating...");
            }
        } else
            System.out.println("Invalid input entered. Terminating...");
    }
}