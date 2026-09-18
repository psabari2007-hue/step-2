public class Solution {
    public static String findMinMaxSpread(int[] scores) {
        // Initialize min and max with the first element of the array
        int min = scores[0];
        int max = scores[0];
        
        // Single pass through the array starting from the second element
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        
        // Calculate the spread (difference between max and min)
        int spread = max - min;
        
        // Return the precisely formatted string match required by the output
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }
}