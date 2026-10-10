package dsa_fundamentals.class_problems;
import java.util.Scanner;

public class WordReverserPalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String word = sc.next();

            StringBuilder sb = new StringBuilder(word);
            String reversed = sb.reverse().toString();

            System.out.println(reversed + " - "
                    + (word.equalsIgnoreCase(reversed)
                    ? "palindrome" : "not a palindrome"));
        }

        sc.close();
    }
}
