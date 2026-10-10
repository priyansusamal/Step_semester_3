package dsa_fundamentals.class_problems;
import java.util.Scanner;

public class StudentResultCardGenerator {

    static double calculateAverage(int[] marks) {
        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        return sum / 3.0;
    }

    static char calculateGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int[] marks = new int[3];

            for (int j = 0; j < 3; j++) {
                marks[j] = sc.nextInt();
            }

            double average = calculateAverage(marks);
            char grade = calculateGrade(average);

            System.out.printf("%s: Average %.1f, Grade %c%n",
                    name.toUpperCase(), average, grade);
        }

        sc.close();
    }
}
