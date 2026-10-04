package abstraction.class_problems;

import java.util.Scanner;

abstract class ElectricityConnection {
    int units;

    ElectricityConnection(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class HomeConnection extends ElectricityConnection {
    HomeConnection(int units) {
        super(units);
    }

    double calculateBill() {
        if (units <= 100) {
            return units * 5;
        }

        return (100 * 5) + ((units - 100) * 7);
    }
}

class ShopConnection extends ElectricityConnection {
    ShopConnection(int units) {
        super(units);
    }

    double calculateBill() {
        return (units * 8) + 100;
    }
}

class FactoryConnection extends ElectricityConnection {
    FactoryConnection(int units) {
        super(units);
    }

    double calculateBill() {
        double bill = units * 6;

        if (bill < 1000) {
            bill = 1000;
        }

        return bill;
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int units = sc.nextInt();

            ElectricityConnection connection;

            switch (type) {
                case "HOME":
                    connection = new HomeConnection(units);
                    break;

                case "SHOP":
                    connection = new ShopConnection(units);
                    break;

                case "FACTORY":
                    connection = new FactoryConnection(units);
                    break;

                default:
                    System.out.println("Invalid connection type");
                    continue;
            }

            double bill = connection.calculateBill();

            System.out.printf("%s: %.2f%n", type, bill);

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}