import java.util.Scanner;

public class PhoneNumberFormatter {

    /**
     * Formats a 10-digit phone number into a masked version: XXXXXX-1234
     * @param phoneNumber The raw phone number input string
     * @return The masked phone number, or an error message if invalid
     */
    public static String maskPhoneNumber(String phoneNumber) {
        // Step 1: Validate length (must be exactly 10 characters)
        if (phoneNumber == null || phoneNumber.length() != 10) {
            return "Error: Phone number must be exactly 10 digits.";
        }

        // Step 2: Validate that all characters are numeric digits
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                return "Error: Phone number must contain only numeric digits.";
            }
        }

        // Step 3: Extract the last 4 digits using substring
        String lastFourDigits = phoneNumber.substring(6);

        // Step 4: Build the masked version using StringBuilder
        StringBuilder maskedBuilder = new StringBuilder();
        maskedBuilder.append("XXXXXX"); // Add the mask
        maskedBuilder.append("-");      // Insert the readability dash
        maskedBuilder.append(lastFourDigits); // Append the last 4 digits

        return maskedBuilder.toString();
    }

    public static void main(String[] args) {
        // Scanner to accept real-time console input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a 10-digit phone number: ");
        String input = scanner.nextLine();

        // Print final formatted result or error
        String result = maskPhoneNumber(input);
        System.out.println(result);

        scanner.close();
    }
}