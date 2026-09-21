import java.util.Scanner;

public class TextStats {

    public static void main(String[] args) {
        // Example usage with the sample input
        countVowelsAndConsonants("Java Programming");
        
        // Optional: Uncomment below to accept dynamic user input
        /*
        Scanner scanner = new Scanner(System.util.in);
        System.out.print("Enter a book title: ");
        String input = scanner.nextLine();
        countVowelsAndConsonants(input);
        scanner.close();
        */
    }

    public static void countVowelsAndConsonants(String text) {
        int vowelsCount = 0;
        int consonantsCount = 0;

        // Loop through each character using length() and charAt()
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Ignore spaces
            if (ch == ' ') {
                continue;
            }

            // Case-insensitive character comparison by converting to lowercase
            char lowerCh = Character.toLowerCase(ch);

            // Check if it's a vowel
            if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
                vowelsCount++;
            } else {
                // Since the prompt states to assume only letters and spaces, 
                // any non-space, non-vowel character is a consonant.
                consonantsCount++;
            }
        }

        // Print the output matching the sample format
        System.out.println("Vowels: " + vowelsCount + " | Consonants: " + consonantsCount);
    }
}