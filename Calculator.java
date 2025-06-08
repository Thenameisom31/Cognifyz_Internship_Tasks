import java.util.*;
class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number of grades : ");
        int n = scanner.nextInt();
        double[] grades = new double[n];
        double sum = 0.0;
        System.out.println("Enter Grade :");
        for(int i=0;i<grades.length;i++) {

              grades[i] = scanner.nextDouble();
              sum += grades[i];
        }
        double average = sum / n;
        System.out.printf("The average grade is:%.2f ",  average);
        scanner.close();

    }
    
}
