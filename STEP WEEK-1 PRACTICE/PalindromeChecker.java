import java.util.Scanner;

public class PalindromeChecker  {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take input from the user
        System.out.print("Enter text: ");
        String input = scanner.nextLine();
        
        // Run all three approaches
        boolean resIterative = isPalindromeIterative(input);
        boolean resRecursive = isPalindromeRecursive(input);
        boolean resArrayReversal = isPalindromeArrayReversal(input);
        
        // Format outputs matching the sample output format
        String strIterative = resIterative ? "Palindrome" : "Not Palindrome";
        String strRecursive = resRecursive ? "Palindrome" : "Not Palindrome";
        String strArrayReversal = resArrayReversal ? "Palindrome" : "Not Palindrome";
        
        // Print the combined result
        System.out.println("Iterative: " + strIterative + " | Recursive: " + strRecursive + " | Array Reversal: " + strArrayReversal);
        
        scanner.close();
    }

    /**
     * Approach 1: Iterative check
     * Compares characters from both ends moving toward the middle.
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        
        int left = 0;
        int right = text.length() - 1;
        
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Approach 2: Recursive check
     * Recursively compares the first and last characters, shrinking the substring.
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        
        // Base case: string with 0 or 1 character is always a palindrome
        if (text.length() <= 1) {
            return true;
        }
        
        // Check outer characters
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        
        // Shrink the substring and call recursively
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    /**
     * Approach 3: Array-reversal check
     * Converts to character array, reverses it, and compares it to original.
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        
        char[] originalArray = text.toCharArray();
        char[] reversedArray = new char[originalArray.length];
        
        // Populating the array in reverse order
        for (int i = 0; i < originalArray.length; i++) {
            reversedArray[i] = originalArray[originalArray.length - 1 - i];
        }
        
        // Convert the reversed array back to a String to check equality
        String reversedText = new String(reversedArray);
        return text.equals(reversedText);
    }
}