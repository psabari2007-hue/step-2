public class BankTransactionValidator {

    // Task 1 & 2: Accept a raw string, trim, and uppercase the first 3 characters
    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }
        
        // Trim leading and trailing spaces
        String trimmed = raw.trim();
        
        // If the string is too short to uppercase the first 3 characters, just uppercase what we can
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        
        // Uppercase only the first 3 characters, keep the rest untouched
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String body = trimmed.substring(3);
        
        return bankCode + body;
    }

    // Task 3, 4 & 5: Validate and build formatted line or print specific error
    public static String validateAndFormat(String reference) {
        if (reference == null) {
            return "Invalid: reference cannot be null";
        }

        // 1. Check length
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // 2. Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // 3. Validate remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // 4. Extract data segments for formatting
        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String sequence = reference.substring(9, 14);

        // 5. Build the formatted display line using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(day).append("/").append(month).append("/").append(year)
          .append(" | SEQ: ").append(sequence);

        return sb.toString();
    }

    // Main method to test sample inputs provided in the image
    public static void main(String[] args) {
        // Test Case 1
        String input1 = " hdf03022600042 ";
        String normalized1 = normalizeReference(input1);
        String result1 = validateAndFormat(normalized1);
        System.out.println("Input:  \"" + input1 + "\"");
        System.out.println("Output: " + result1);
        System.out.println();

        // Test Case 2
        String input2 = "12F03022600042";
        String normalized2 = normalizeReference(input2);
        String result2 = validateAndFormat(normalized2);
        System.out.println("Input:  \"" + input2 + "\"");
        System.out.println("Output: " + result2);
    }
}