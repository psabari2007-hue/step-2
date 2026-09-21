public class Solution  {

    // Method to reverse the customer name
    public static String reverseCustomerName(String customerName) {
        // Handle null or empty edge cases
        if (customerName == null) {
            return null;
        }
        
        StringBuilder reversed = new StringBuilder(customerName);
        return reversed.reverse().toString();
    }

    // Main method to execute and print the results
    public static void main(String[] args) {
        // Sample Input
        String originalName = "Sunil";
        
        // Method Call
        String reversedName = reverseCustomerName(originalName);
        
        // Output formatting matching the prompt requirements
        System.out.println("Original Name: " + originalName);
        System.out.println("Reversed Name: " + reversedName);
    }
}