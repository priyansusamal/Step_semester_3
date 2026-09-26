package polymorphism.class_problems;

import java.util.Scanner;
import java.time.LocalDate;

abstract class LibraryItem {
    abstract int getLoanDays();
}

class Book extends LibraryItem {
    int getLoanDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    int getLoanDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    int getLoanDays() {
        return 3;
    }
}

public class LibraryDueDateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LocalDate issueDate = LocalDate.of(2023, 10, 26);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String type = sc.nextLine();
            String title = sc.nextLine();

            LibraryItem item;

            switch (type.toUpperCase()) {
                case "BOOK":
                    item = new Book();
                    break;
                case "DVD":
                    item = new DVD();
                    break;
                case "MAGAZINE":
                    item = new Magazine();
                    break;
                default:
                    System.out.println("Invalid item type");
                    continue;
            }

            LocalDate dueDate = issueDate.plusDays(item.getLoanDays());

            System.out.println(title + " - " + dueDate);
        }

        sc.close();
    }
}