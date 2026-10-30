public class Solution {
    
    /**
     * Finds the index of the row with the largest total number of students.
     * Returns an array containing {bestRowIndex, maxTotal}.
     */
    public static int[] busiestRow(int[][] grid) {
        int maxTotal = -1;
        int bestRowIndex = -1;
        
        // Loop through each row
        for (int i = 0; i < grid.length; i++) {
            int currentTail = 0;
            
            // Sum up the students in the current row
            for (int j = 0; j < grid[i].length; j++) {
                currentTail += grid[i][j];
            }
            
            // Update only if the current row's total is strictly larger
            if (currentTail > maxTotal) {
                maxTotal = currentTail;
                bestRowIndex = i;
            }
        }
        
        return new int[]{bestRowIndex, maxTotal};
    }

    // Main method to test the example from the problem description
    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };
        
        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}