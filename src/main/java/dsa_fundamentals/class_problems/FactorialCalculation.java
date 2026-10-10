package dsa_fundamentals.class_problems;
import java.util.Scanner;
import java.math.BigInteger;

public class FactorialCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            BigInteger factorial = BigInteger.ONE;

            for (int i = 1; i <= n; i++) {
                factorial = factorial.multiply(
                        BigInteger.valueOf(i));
            }

            System.out.println(factorial);
        }

        sc.close();
    }
}
