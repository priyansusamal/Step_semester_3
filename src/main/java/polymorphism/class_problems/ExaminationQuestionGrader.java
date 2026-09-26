package polymorphism.class_problems;

import java.util.Scanner;

abstract class Question {
    double points;

    Question(double points) {
        this.points = points;
    }

    abstract double grade(String answer, String keywords);
}

class MCQ extends Question {
    String correctAnswer;

    MCQ(double points, String correctAnswer) {
        super(points);
        this.correctAnswer = correctAnswer;
    }

    double grade(String answer, String keywords) {
        if (answer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class TrueFalse extends Question {
    String correctAnswer;

    TrueFalse(double points, String correctAnswer) {
        super(points);
        this.correctAnswer = correctAnswer;
    }

    double grade(String answer, String keywords) {
        if (answer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class Essay extends Question {
    Essay(double points) {
        super(points);
    }

    double grade(String answer, String keywords) {
        String[] words = keywords.split(",");
        int count = 0;

        for (String word : words) {
            if (answer.toLowerCase().contains(word.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationQuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String type = sc.nextLine().toUpperCase();
        double points = Double.parseDouble(sc.nextLine());
        String answer = sc.nextLine();
        String correctAnswer = sc.nextLine();

        Question question;

        switch (type) {
            case "MCQ":
                question = new MCQ(points, correctAnswer);
                break;
            case "TF":
                question = new TrueFalse(points, correctAnswer);
                break;
            case "ESSAY":
                question = new Essay(points);
                break;
            default:
                System.out.println("Invalid question type");
                sc.close();
                return;
        }

        double score = question.grade(answer, correctAnswer);

        System.out.printf("Score: %.2f%n", score);

        sc.close();
    }
}