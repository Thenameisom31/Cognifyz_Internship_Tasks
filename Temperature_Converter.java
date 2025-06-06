import java.util.Scanner;

public class Temperature_Converter {

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Temperature Converter ===");
        System.out.print("Enter temperature value: ");

        if (scanner.hasNextDouble()) {
            double temp = scanner.nextDouble();
            System.out.print("Is this in Celsius or Fahrenheit? (C/F): ");
            String unit = scanner.next().trim().toUpperCase();

            if (unit.equals("C")) {
                double result = celsiusToFahrenheit(temp);
                System.out.printf("%.2f°C is equal to %.2f°F%n", temp, result);
            } else if (unit.equals("F")) {
                double result = fahrenheitToCelsius(temp);
                System.out.printf("%.2f°F is equal to %.2f°C%n", temp, result);
            } else {
                System.out.println("Invalid unit! Please enter 'C' or 'F'.");
            }
        } else {
            System.out.println("Invalid input! Please enter a numeric value.");
        }

        scanner.close();
    }
}
