package dsa_fundamentals.class_problems;
import java.util.Scanner;

public class StudentGradeAssignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int marks = sc.nextInt();
            char grade;

            if (marks >= 90) {
                grade = 'A';
            } else if (marks >= 75) {
                grade = 'B';
            } else if (marks >= 60) {
                grade = 'C';
            } else if (marks >= 40) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            System.out.println("Grade " + grade);
        }

        sc.close();
    }
}
