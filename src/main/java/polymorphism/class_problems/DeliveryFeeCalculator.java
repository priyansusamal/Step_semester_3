package polymorphism.class_problems;

import java.util.Scanner;

abstract class Delivery {
    abstract double calculateFee(double weight, double distance);
}

class StandardDelivery extends Delivery {
    double calculateFee(double weight, double distance) {
        return 5 + (0.5 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends Delivery {
    double calculateFee(double weight, double distance) {
        return 15 + (1.0 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends Delivery {
    double customsFee;

    InternationalDelivery(double customsFee) {
        this.customsFee = customsFee;
    }

    double calculateFee(double weight, double distance) {
        return 25 + (2.0 * weight) + (0.50 * distance) + customsFee;
    }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String type = sc.next().toUpperCase();
        double weight = sc.nextDouble();
        double distance = sc.nextDouble();

        Delivery delivery;

        switch (type) {
            case "STANDARD":
                delivery = new StandardDelivery();
                break;
            case "EXPRESS":
                delivery = new ExpressDelivery();
                break;
            case "INTERNATIONAL":
                double customsFee = sc.nextDouble();
                delivery = new InternationalDelivery(customsFee);
                break;
            default:
                System.out.println("Invalid delivery type");
                sc.close();
                return;
        }

        double fee = delivery.calculateFee(weight, distance);

        System.out.printf("Delivery Fee: %.2f%n", fee);

        sc.close();
    }
}