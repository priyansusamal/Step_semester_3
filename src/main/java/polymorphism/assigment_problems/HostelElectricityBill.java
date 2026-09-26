package polymorphism.assigment_problems;

import java.util.Scanner;

abstract class Room {
    abstract double calculateBill(int units);
}

class SingleRoom extends Room {
    double calculateBill(int units) {
        return units * 8;
    }
}

class SharedRoom extends Room {
    int occupants;

    SharedRoom(int occupants) {
        this.occupants = occupants;
    }

    double calculateBill(int units) {
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    double calculateBill(int units) {
        return (units * 10) + 200;
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int units = sc.nextInt();

            Room room;

            switch (type) {
                case "SINGLE":
                    room = new SingleRoom();
                    break;

                case "SHARED":
                    int occupants = sc.nextInt();
                    room = new SharedRoom(occupants);
                    break;

                case "AC":
                    room = new ACRoom();
                    break;

                default:
                    System.out.println("Invalid room type");
                    continue;
            }

            double bill = room.calculateBill(units);

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}