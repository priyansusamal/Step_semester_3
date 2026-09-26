package polymorphism.assigment_problems;

import java.util.Scanner;

abstract class Customer {
    abstract double calculateFinalAmount(double amount);
}

class Student extends Customer {
    double calculateFinalAmount(double amount) {
        return amount - (amount * 0.10);
    }
}

class Staff extends Customer {
    double calculateFinalAmount(double amount) {
        return amount - (amount * 0.05);
    }
}

class Guest extends Customer {
    double calculateFinalAmount(double amount) {
        return amount + 10;
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();

            Customer customer;

            switch (type) {
                case "STUDENT":
                    customer = new Student();
                    break;
                case "STAFF":
                    customer = new Staff();
                    break;
                case "GUEST":
                    customer = new Guest();
                    break;
                default:
                    System.out.println("Invalid customer type");
                    continue;
            }

            double finalAmount = customer.calculateFinalAmount(amount);

            System.out.printf("%s: %.2f%n", type, finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}