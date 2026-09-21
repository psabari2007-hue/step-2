public class SeatingOptimizer {

    // Helper method to compute a single row's average
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0; 
        }
        
        double sum = 0;
        for (int score : row) {
            sum += score;
        }
        
        // Handles varying column lengths (jagged grids) dynamically
        return sum / row.length;
    }

    // Main classification method
    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < seatingScores.length; i++) {
            // Call the helper exactly once per row
            double avg = rowAverage(seatingScores[i]);
            
            // Determine zone classification in the outer loop
            String zone = (avg < threshold) ? "Quiet Zone" : "Buzzing Zone";
            
            // Format the output string
            result.append("Row ").append(i).append(": ").append(zone);
            
            // Append the separator for all but the last item
            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }
        
        return result.toString();
    }

    // Example test run matching the problem description
    public static void main(String[] args) {
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold = 60;

        String classification = classifyRows(seatingScores, threshold);
        System.out.println(classification);
        // Output: Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone
    }
}