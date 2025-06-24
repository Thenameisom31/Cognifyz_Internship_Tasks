import java.util.Scanner;

public class Temp_Converter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user
        System.out.print("Enter temperature value: ");
        double temperature = sc.nextDouble();

        System.out.print("Enter unit (C for Celsius, F for Fahrenheit): ");
        char unit = sc.next().toUpperCase().charAt(0);

        double convertedTemp;
        if (unit == 'C') {
            // Celsius to Fahrenheit
            convertedTemp = (temperature * 9 / 5) + 32;
            System.out.printf("Temperature in Fahrenheit: %.2f°F\n", convertedTemp);
        } else if (unit == 'F') {
            // Fahrenheit to Celsius
            convertedTemp = (temperature - 32) * 5 / 9;
            System.out.printf("Temperature in Celsius: %.2f°C\n", convertedTemp);
        } else {
            System.out.println("Invalid unit entered. Use C or F.");
        }

        sc.close();
    }
}