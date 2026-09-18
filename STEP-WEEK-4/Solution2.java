public class Solution2 {
    public int maxSubArray(int[] nums) {
        // Handle empty array edge case
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Initialize tracking variables with the first element
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Kadane's core choice: extend the existing subarray or start a fresh one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update the global maximum if the current subarray sum is larger
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}