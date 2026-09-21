public class Solution {
    public static int[] findTopThreeScores(int[] scores) {
        // Initialize the top three tracking variables to the smallest possible integer
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        // Scan through the scores array exactly once
        for (int score : scores) {
            if (score > first) {
                // Shift down all values
                third = second;
                second = first;
                first = score;
            } else if (score > second) {
                // Shift down from second position
                third = second;
                second = score;
            } else if (score > third) {
                // Update only the third position
                third = score;
            }
        }

        // Return the final top 3 scores in descending order
        return new int[]{first, second, third};
    }
}