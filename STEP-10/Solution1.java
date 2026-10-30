public class Solution1 {
    public static int secondHighest(int[] scores) {
        int highest = -1;
        int secondHighest = -1;

        for (int score : scores) {
            if (score > highest) {
                // The old highest becomes the new second-highest
                secondHighest = highest;
                highest = score;
            } else if (score < highest && score > secondHighest) {
                // The score is distinct and strictly greater than the current second-highest
                secondHighest = score;
            }
        }

        return secondHighest;
    }

    public static void main(String[] args) {
        // Sample 1 Test
        int[] scores1 = {45, 78, 92, 78, 60};
        System.out.println("Sample 1 Output: " + secondHighest(scores1)); // Expected: 78

        // Sample 2 Test
        int[] scores2 = {50, 50, 50};
        System.out.println("Sample 2 Output: " + secondHighest(scores2)); // Expected: -1
    }
}