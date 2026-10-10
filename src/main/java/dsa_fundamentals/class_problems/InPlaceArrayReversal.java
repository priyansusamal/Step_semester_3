package dsa_fundamentals.class_problems;

import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InPlaceArrayReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Matcher matcher = Pattern.compile("-?\\d+").matcher(input);

        int[] array = new int[input.length()];
        int size = 0;

        while (matcher.find()) {
            array[size++] = Integer.parseInt(matcher.group());
        }

        array = Arrays.copyOf(array, size);

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }

        System.out.println(Arrays.toString(array));

        sc.close();
    }
}
