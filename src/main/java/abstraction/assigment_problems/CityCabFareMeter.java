package abstraction.assigment_problems;

import java.util.Scanner;

abstract class Cab {
    static final double MINIMUM_FARE = 100;

    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    abstract String getCabType();

    abstract boolean supportsNightService();

    double calculateFare() {
        double fare = km * getRate();

        if (fare < MINIMUM_FARE) {
            fare = MINIMUM_FARE;
        }

        return fare;
    }
}

interface NightService {
    boolean supportsNightService();
}

class MiniCab extends Cab {
    MiniCab(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }

    String getCabType() {
        return "MINI";
    }

    boolean supportsNightService() {
        return false;
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    String getCabType() {
        return "SEDAN";
    }

    public boolean supportsNightService() {
        return true;
    }
}

class SUVCab extends Cab implements NightService {
    SUVCab(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    String getCabType() {
        return "SUV";
    }

    public boolean supportsNightService() {
        return true;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String cabType = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (cabType.equals("MINI")) {
                cab = new MiniCab(km);
            } else if (cabType.equals("SEDAN")) {
                cab = new SedanCab(km);
            } else {
                cab = new SUVCab(km);
            }

            if (time.equals("NIGHT") && !cab.supportsNightService()) {
                System.out.println(cab.getCabType() + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {
                fare = fare * 1.20;
            }

            System.out.printf("%s: %.2f%n", cab.getCabType(), fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}