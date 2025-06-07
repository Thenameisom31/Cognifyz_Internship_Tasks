import java.util.*;

public class Check_palindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder reversed = new StringBuilder(cleanedInput).reverse();
        String reversedInput = reversed.toString().toLowerCase();
        if (cleanedInput.equals(reversedInput)) 
        {
            System.out.println("The string is a palindrome.");
        } else 
        {
            System.out.println("The string is not a palindrome.");
        }

        scanner.close();
    }

}