package polymorphism.class_problems;

import java.util.Scanner;

abstract class Payment {
    abstract double calculateFee(double amount);
}

class CardPayment extends Payment {
    double calculateFee(double amount) {
        return amount * 0.02;
    }
}

class WalletPayment extends Payment {
    double calculateFee(double amount) {
        return amount * 0.01;
    }
}

class BankTransfer extends Payment {
    double calculateFee(double amount) {
        return 0;
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();

            Payment payment;

            switch (type) {
                case "CARD":
                    payment = new CardPayment();
                    break;
                case "WALLET":
                    payment = new WalletPayment();
                    break;
                case "BANKTRANSFER":
                    payment = new BankTransfer();
                    break;
                default:
                    System.out.println("Invalid payment type");
                    continue;
            }

            double fee = payment.calculateFee(amount);
            double adjustedAmount = amount + fee;

            System.out.printf("%.2f %.2f%n", fee, adjustedAmount);
            total += adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}