public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Outer loop iterates through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Inner loop starts from the next element to check pairs
            for (int j = i + 1; j < nums.length; j++) {
                // If the sum of the elements at positions i and j equals the target
                if (nums[i] + nums[j] == target) {
                    // Return the indices immediately as an array
                    return new int[] { i, j };
                }
            }
        }
        // Return an empty array if no match is found (though the problem guarantees one)
        return new int[] {};
    }
}