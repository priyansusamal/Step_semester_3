package abstraction.assigment_problems;

import java.util.Scanner;

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    abstract String getName();

    abstract boolean supportsSaverMode();

    double calculateUnits() {
        return (getPower() * hours) / 1000;
    }

    double calculateCost() {
        return calculateUnits() * 8;
    }
}

interface SaverMode {
    boolean supportsSaverMode();
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }

    String getName() {
        return "FRIDGE";
    }

    boolean supportsSaverMode() {
        return false;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    String getName() {
        return "AC";
    }

    public boolean supportsSaverMode() {
        return true;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }

    String getName() {
        return "TV";
    }

    boolean supportsSaverMode() {
        return false;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    String getName() {
        return "WASHER";
    }

    public boolean supportsSaverMode() {
        return true;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String applianceType = sc.next();
            double hours = sc.nextDouble();

            boolean saverRequested = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saverRequested = true;
            }

            Appliance appliance;

            if (applianceType.equals("FRIDGE")) {
                appliance = new Fridge(hours);
            } else if (applianceType.equals("AC")) {
                appliance = new AirConditioner(hours);
            } else if (applianceType.equals("TV")) {
                appliance = new TV(hours);
            } else {
                appliance = new Washer(hours);
            }

            if (saverRequested && !appliance.supportsSaverMode()) {
                System.out.println(
                    appliance.getName() + ": saver mode not supported"
                );
                continue;
            }

            double units = appliance.calculateUnits();

            if (saverRequested) {
                units = units * 0.75;
            }

            double cost = units * 8;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                appliance.getName(), units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}