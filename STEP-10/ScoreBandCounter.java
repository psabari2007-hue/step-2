public class ScoreBandCounter {

    public static int countInBand(int[] scores, int low, int high) {
        // Find the first index where score >= low
        int leftIndex = findLowerBound(scores, low);
        // Find the first index where score > high
        int rightIndex = findUpperBound(scores, high);
        
        // The total count is the difference between the two indices
        return rightIndex - leftIndex;
    }

    // Finds the first index where elements are >= target
    private static int findLowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                right = mid; // Look left to find the very first occurrence
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Finds the first index where elements are > target
    private static int findUpperBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) {
                right = mid; // Look left to find the first element strictly greater
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Main method to test the examples provided
    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        // Sample 1
        System.out.println("Sample 1 Output: " + countInBand(scores, 42, 58)); // Expected: 6

        // Sample 2
        System.out.println("Sample 2 Output: " + countInBand(scores, 90, 100)); // Expected: 0
    }
}