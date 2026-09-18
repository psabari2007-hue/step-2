public class MatchAnalyzer {

    /**
     * Helper method to compute the average runs for a single match (row).
     * Handles jagged arrays safely by dynamically using row.length.
     */
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        
        double totalRuns = 0;
        for (int runs : row) {
            totalRuns += runs;
        }
        
        return totalRuns / row.length;
    }

    /**
     * Classifies each match as either "Power Surge" or "Normal" based on the threshold.
     */
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            // Call the helper method exactly once per match
            double average = rowAverage(runsPerOver[i]);
            
            // Determine classification at or above threshold
            String status = (average >= threshold) ? "Power Surge" : "Normal";
            
            // Build the formatted output string
            result.append("Match ").append(i).append(": ").append(status);
            
            // Add delimiters between matches, but not after the last one
            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    // Main method to test the example from the problem statement
    public static void main(String[] args) {
        int[][] exampleInput = {
            {4, 6, 8},      // Avg: 6.0 (< 8) -> Normal
            {10, 12, 14},   // Avg: 12.0 (>= 8) -> Power Surge
            {2, 3, 1}       // Avg: 2.0 (< 8) -> Normal
        };
        int threshold = 8;

        String output = classifyMatches(exampleInput, threshold);
        System.out.println(output);
        // Output: Match 0: Normal | Match 1: Power Surge | Match 2: Normal
    }
}