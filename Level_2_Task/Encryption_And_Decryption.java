import java.io.*;
import java.util.*;

public class Encryption_And_Decryption {

    static final String SYMBOLS = "!@#$%^&*()-_=+[]{};:'\",.<>?/\\|`~";

    public static void encryptFile(String inputFile, String encryptedFile) {
        File outFile = new File(encryptedFile);
        if (outFile.exists()) {
            System.out.println("File already encrypted: " + encryptedFile);
            return;
        }

        try (Scanner scanner = new Scanner(new FileInputStream(inputFile));
             FileWriter writer = new FileWriter(encryptedFile)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                StringBuilder encryptedBuffer = new StringBuilder();
                int letterCount = 0;

                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);

                    if (Character.isLowerCase(ch)) {
                        ch = (char) ('A' + (ch - 'a' + 3) % 26);
                        encryptedBuffer.append(ch);
                        letterCount++;
                    } else if (Character.isUpperCase(ch)) {
                        ch = (char) ('A' + (ch - 'A' + 3) % 26);
                        encryptedBuffer.append(ch);
                        letterCount++;
                    } else if (SYMBOLS.indexOf(ch) != -1) {
                        int index = SYMBOLS.indexOf(ch);
                        int newIndex = (index + 3) % SYMBOLS.length();
                        encryptedBuffer.append(SYMBOLS.charAt(newIndex));
                    } else {
                        encryptedBuffer.append(ch);
                    }

                    if (letterCount == 40) {
                        writer.write(encryptedBuffer.toString() + "\n");
                        encryptedBuffer.setLength(0);
                        letterCount = 0;
                    }
                }

                if (encryptedBuffer.length() > 0) {
                    writer.write(encryptedBuffer.toString() + "\n");
                }
            }

            System.out.println("Encryption completed. Output written to " + encryptedFile);

        } catch (Exception e) {
            System.out.println("Error encrypting file: " + e.getMessage());
        }
    }

    public static void decryptFile(String encryptedFile, String outputFile) {
        File file = new File(encryptedFile);
        if (!file.exists()) {
            System.out.println("Encrypted file not found: " + encryptedFile);
            System.out.println("Please encrypt the file first.");
            return;
        }

        try (Scanner scanner = new Scanner(file);
             FileWriter writer = new FileWriter(outputFile)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                StringBuilder decryptedLine = new StringBuilder();

                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);

                    if (Character.isUpperCase(ch)) {
                        char original = (char) ('a' + (ch - 'A' - 3 + 26) % 26);
                        decryptedLine.append(original);
                    } else if (SYMBOLS.indexOf(ch) != -1) {
                        int index = SYMBOLS.indexOf(ch);
                        int newIndex = (index - 3 + SYMBOLS.length()) % SYMBOLS.length();
                        decryptedLine.append(SYMBOLS.charAt(newIndex));
                    } else {
                        decryptedLine.append(ch);
                    }
                }

                writer.write(decryptedLine.toString() + "\n");
            }

            System.out.println("Decryption complete. Output written to " + outputFile);

        } catch (Exception e) {
            System.out.println("Error decrypting file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] files = {
            "TextData1.txt", "TextData2.txt", "TextData3.txt",
            "TextData4.txt", "TextData5.txt"
        };

        while (true) {
            System.out.println("\n=== File Encrypt/Decrypt Menu ===");
            for (int i = 0; i < files.length; i++) {
                System.out.println((i + 1) + ". " + files[i]);
            }
            System.out.println("6. Exit");

            System.out.print("Choose file number to work with (1-5) or 6 to exit: ");
            int fileChoice = input.nextInt();
            input.nextLine();

            if (fileChoice == 6) {
                System.out.println("Exiting...");
                break;
            }

            if (fileChoice < 1 || fileChoice > 5) {
                System.out.println("Invalid choice. Please select a number between 1 and 5.");
                continue;
            }

            String inputFile = "TextData" + fileChoice + ".txt";
            String encryptedFile = "DecryptFile" + fileChoice + ".txt";
            String decryptedFile = "AfterDecryptedFile" + fileChoice + ".txt";

            System.out.println("Selected: " + inputFile);
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.print("Enter your choice: ");
            int action = input.nextInt();
            input.nextLine();

            if (action == 1) {
                encryptFile(inputFile, encryptedFile);
            } else if (action == 2) {
                decryptFile(encryptedFile, decryptedFile);
            } else {
                System.out.println("Invalid option.");
            }
        }

        input.close();
    }
}
