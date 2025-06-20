import java.util.*;

public class PasswordStrengthChecker {
    static int check = 0;

    static int isStrongPassword(String password) {

        if (password.length() >= 8) {
            check++;
        }

        if (password.matches(".*[A-Z].*")) {

            check++;
        }

        if (password.matches(".*[a-z].*")) {
            check++;
        }

        if (password.matches(".*\\d.*")) {
            check++;
        }

        if (password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            check++;
        }
        return check;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        int check = isStrongPassword(password);

        if (check == 5) {
            System.out.println("The password is strong.");

        } else if (check > 2 && check < 5) {
            System.out.println("The password is Moderate.");

        } else {
            System.out.println("The password is weak.");

        }

        scanner.close();
    }
}