package abstraction.class_problems;

import java.util.Scanner;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    double hours;
    double rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }

        double regularPay = 40 * rate;
        double overtimeHours = hours - 40;
        double overtimePay = overtimeHours * rate * 1.5;

        return regularPay + overtimePay;
    }
}

class InternStaff extends Staff {
    double stipend;

    InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalPayroll = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            Staff staff;

            switch (type) {
                case "FULLTIME":
                    double weeklySalary = sc.nextDouble();
                    staff = new FullTimeStaff(name, weeklySalary);
                    break;

                case "HOURLY":
                    double hours = sc.nextDouble();
                    double rate = sc.nextDouble();
                    staff = new HourlyStaff(name, hours, rate);
                    break;

                case "INTERN":
                    double stipend = sc.nextDouble();
                    staff = new InternStaff(name, stipend);
                    break;

                default:
                    System.out.println("Invalid staff type");
                    continue;
            }

            double pay = staff.calculatePay();

            System.out.printf("%s: %.2f%n", staff.name, pay);

            totalPayroll += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", totalPayroll);

        sc.close();
    }
}