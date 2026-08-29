import java.util.Scanner;
import java.util.HashMap;

public class FirstNonRepeating {

    static char findFirstNonRepeatingChar(String text) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count characters
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
            else {
                map.put(ch, 1);
            }
        }

        // Find first character with count 1
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (map.get(ch) == 1) {
                return ch;
            }
        }

        return '\0';
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        char answer = findFirstNonRepeatingChar(text);

        if (answer == '\0') {
            System.out.println("No Non-Repeating Character Found");
        }
        else {
            System.out.println("First Non-Repeating Character: '" + answer + "'");
        }
    }
}
