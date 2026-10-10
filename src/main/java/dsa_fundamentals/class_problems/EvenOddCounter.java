package dsa_fundamentals.class_problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Matcher matcher = Pattern.compile("-?\\d+").matcher(input);

        int even = 0;
        int odd = 0;

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());

            if (number % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);

        sc.close();
    }
}
