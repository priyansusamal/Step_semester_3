package abstraction.class_problems;

import java.util.Scanner;

abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class BookItem extends LibraryItem {
    BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate * 2;
    }
}

class DVDItem extends LibraryItem {
    DVDItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        double fine = daysLate * 5;

        if (fine > 50) {
            fine = 50;
        }

        return fine;
    }
}

class MagazineItem extends LibraryItem {
    MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalFines = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String title = sc.next();
            int daysLate = sc.nextInt();

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new BookItem(title, daysLate);
                    break;

                case "DVD":
                    item = new DVDItem(title, daysLate);
                    break;

                case "MAGAZINE":
                    item = new MagazineItem(title, daysLate);
                    break;

                default:
                    System.out.println("Invalid item type");
                    continue;
            }

            double fine = item.calculateFine();

            System.out.printf("%s: %.2f%n", item.title, fine);

            totalFines += fine;
        }

        System.out.printf("Total Fines: %.2f%n", totalFines);

        sc.close();
    }
}