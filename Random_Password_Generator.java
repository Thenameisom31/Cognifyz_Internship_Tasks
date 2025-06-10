import java.util.*;
public class Random_Password_Generator {

    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the length of the password:");
        int length = sc.nextInt();
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallLetters = "abcdefghijklmnopqrstuvwxyz"; 
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:,.<>?";  
        sc.nextLine(); // Consume the newline character left by nextInt()
        System.out.println("Include capital letters? (yes/no)");
        Boolean includeCapital = sc.next().equalsIgnoreCase("yes");
        System.out.println("Include small letters? (yes/no)");
        Boolean includeSmall = sc.next().equalsIgnoreCase("yes");       
        System.out.println("Include numbers? (yes/no)");
        Boolean includeNumbers = sc.next().equalsIgnoreCase("yes");        
        System.out.println("Include special characters? (yes/no)");
        Boolean includeSpecial = sc.next().equalsIgnoreCase("yes");
        sc.close();
        String allCharacters = "";

        Random random = new Random();
        if(includeCapital) {
            allCharacters += capitalLetters;
        }   
        if(includeSmall) {
            allCharacters += smallLetters;
        }
        if(includeNumbers) {
            allCharacters += numbers;
        }
        if(includeSpecial) {
            allCharacters += specialCharacters;
        }
        // Check if at least one type of character is included
        if(allCharacters.isEmpty()) {
            System.out.println("You must include at least one type of character.");
            return;
        }   

        StringBuilder password = new StringBuilder();
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(allCharacters.length());
            password.append(allCharacters.charAt(index));
        }
        System.out.println("Generated Password: " + password.toString());
        
    }
}