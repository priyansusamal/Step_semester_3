package abstraction.class_problems;

import java.util.Scanner;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();

    abstract String getShape();
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    String getShape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    double length;
    double width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }

    String getShape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    double base;
    double height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }

    String getShape() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalArea = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next().toUpperCase();
            String owner = sc.next();

            Plot plot;

            switch (shape) {
                case "CIRCLE":
                    double radius = sc.nextDouble();
                    plot = new Circle(owner, radius);
                    break;

                case "RECTANGLE":
                    double length = sc.nextDouble();
                    double width = sc.nextDouble();
                    plot = new Rectangle(owner, length, width);
                    break;

                case "TRIANGLE":
                    double base = sc.nextDouble();
                    double height = sc.nextDouble();
                    plot = new Triangle(owner, base, height);
                    break;

                default:
                    System.out.println("Invalid shape");
                    continue;
            }

            double area = plot.calculateArea();

            System.out.printf(
                "%s (%s): %.2f%n",
                plot.owner,
                plot.getShape(),
                area
            );

            totalArea += area;
        }

        System.out.printf("Total Area: %.2f%n", totalArea);

        sc.close();
    }
}