import java.util.Scanner;
public class Palindrome {
    static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text) {

        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    static boolean isPalindromeArrayReversal(String text) {

        char[] arr = text.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        String reversed = new String(arr);

        return text.equals(reversed);
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        boolean result1 = isPalindromeIterative(text);
        boolean result2 = isPalindromeRecursive(text);
        boolean result3 = isPalindromeArrayReversal(text);

        if (result1) {
            System.out.println("Iterative: Palindrome");
        }
        else {
            System.out.println("Iterative: Not Palindrome");
        }

        if (result2) {
            System.out.println("Recursive: Palindrome");
        }
        else {
            System.out.println("Recursive: Not Palindrome");
        }

        if (result3) {
            System.out.println("Array Reversal: Palindrome");
        }
        else {
            System.out.println("Array Reversal: Not Palindrome");
        }
    }
}