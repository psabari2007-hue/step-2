import java.util.HashMap;

public class UniqueLetterHunt  {

    /**
     * Finds the first character that appears only once in the string.
     * Returns '\0' if no non-repeating character is found.
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        // Step 1: Compute the frequency of every character
        HashMap<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        // Step 2: Scan the string left to right to find the first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (charCounts.get(c) == 1) {
                return c; // Early-exit upon finding the first unique character
            }
        }

        // Return a null character indicator if no unique match exists
        return '\0';
    }

    /**
     * Helper method to execute test cases and print output matched to the prompt style
     */
    public static void testGame(String input) {
        char result = findFirstNonRepeatingChar(input);
        
        System.out.println("Input: \"" + input + "\"");
        if (result != '\0') {
            System.out.println("Output: First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("Output: No Non-Repeating Character Found");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Run test samples provided in the assignment prompt
        testGame("swiss");
        testGame("aabbcc");
    }
}