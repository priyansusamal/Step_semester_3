import java.util.Scanner;

public class ReverseName {

    static String reverseCustomerName(String customerName) {

        String reversed = "";

        for (int i = customerName.length() - 1; i >= 0; i--) {

            reversed = reversed + customerName.charAt(i);
        }

        return reversed;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String customerName = sc.nextLine();

        String reversed = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversed);
    }
}
