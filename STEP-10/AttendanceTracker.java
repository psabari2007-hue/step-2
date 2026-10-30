public class AttendanceTracker {

    /**
     * Calculates the total number of present days and the longest consecutive streak.
     * @param days Array containing 1s (present) and 0s (absent)
     * @return An array where index 0 is 'Present days' and index 1 is 'Longest streak'
     */
    public static int[] attendanceSummary(int[] days) {
        int totalPresent = 0;
        int longestStreak = 0;
        int currentStreak = 0;

        // Single pass through the array
        for (int day : days) {
            if (day == 1) {
                totalPresent++;
                currentStreak++;
                // Update longest streak if the current one exceeds it
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                // Reset the streak tracking on an absent day (0)
                currentStreak = 0;
            }
        }

        return new int[]{totalPresent, longestStreak};
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] sample1 = {1, 1, 0, 1, 1, 1, 0, 1};
        int[] result1 = attendanceSummary(sample1);
        System.out.println("Sample 1 - Present: " + result1[0] + ", Longest streak: " + result1[1]);

        // Sample Test Case 2
        int[] sample2 = {0, 0, 0};
        int[] result2 = attendanceSummary(sample2);
        System.out.println("Sample 2 - Present: " + result2[0] + ", Longest streak: " + result2[1]);
    }
}