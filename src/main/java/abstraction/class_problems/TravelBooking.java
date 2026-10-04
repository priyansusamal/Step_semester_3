package abstraction.class_problems;

import java.util.Scanner;

abstract class Booking {
    static final double BOOKING_FEE = 50;

    double distance;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    BusBooking(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return 2 * distance;
    }
}

class TrainBooking extends Booking {
    TrainBooking(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return 1.5 * distance;
    }
}

class FlightBooking extends Booking {
    FlightBooking(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return 2500 + (4 * distance);
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next().toUpperCase();
            double distance = sc.nextDouble();

            Booking booking;

            switch (mode) {
                case "BUS":
                    booking = new BusBooking(distance);
                    break;

                case "TRAIN":
                    booking = new TrainBooking(distance);
                    break;

                case "FLIGHT":
                    booking = new FlightBooking(distance);
                    break;

                default:
                    System.out.println("Invalid travel mode");
                    continue;
            }

            double total = booking.calculateTotalFare();

            System.out.printf("%s: %.2f%n", mode, total);
        }

        sc.close();
    }
}