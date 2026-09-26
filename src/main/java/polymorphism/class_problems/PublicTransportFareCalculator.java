package polymorphism.class_problems;

import java.util.Scanner;

abstract class Transport {
    abstract double calculateFare(double distance, double peakFactor);
}

class Bus extends Transport {
    double calculateFare(double distance, double peakFactor) {
        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }
}

class Train extends Transport {
    double calculateFare(double distance, double peakFactor) {
        return 3 + (0.15 * distance);
    }
}

class Metro extends Transport {
    double calculateFare(double distance, double peakFactor) {
        return (1.50 + (0.20 * distance)) * peakFactor;
    }
}

public class PublicTransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String type = sc.next().toUpperCase();
        double distance = sc.nextDouble();
        double peakFactor = 1.0;

        if (type.equals("METRO")) {
            peakFactor = sc.nextDouble();
        }

        Transport transport;

        switch (type) {
            case "BUS":
                transport = new Bus();
                break;
            case "TRAIN":
                transport = new Train();
                break;
            case "METRO":
                transport = new Metro();
                break;
            default:
                System.out.println("Invalid transport type");
                sc.close();
                return;
        }

        double fare = transport.calculateFare(distance, peakFactor);

        System.out.printf("Fare: %.2f%n", fare);

        sc.close();
    }
}