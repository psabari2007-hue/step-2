public class FileExtensionValidator {

    public static String validateFileExtension(String filename) {
        // Find the index of the last '.' character
        int lastDotIndex = filename.lastIndexOf('.');
        
        // If there is no dot, or it's the last character in the string, it's invalid
        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }
        
        // Extract the extension using substring (skipping the '.')
        String extension = filename.substring(lastDotIndex + 1);
        
        // Compare case-insensitively against the allowed extensions
        if (extension.equalsIgnoreCase("pdf") || 
            extension.equalsIgnoreCase("docx") || 
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }

    // Main method to test the sample inputs
    public static void main(String[] args) {
        // Test Case 1
        System.out.println(validateFileExtension("Assignment1.PDF")); 
        // Output: Accepted

        // Test Case 2
        System.out.println(validateFileExtension("notes.txt"));       
        // Output: Rejected — invalid file type
    }
}