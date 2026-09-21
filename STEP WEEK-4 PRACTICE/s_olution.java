public class Solution {
    public int[] rotateArray(int[] nums, int k) {
        // Handle edge cases where array is empty or null
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n = nums.length;

        // Step 1: Reduce k using modulo arithmetic
        k = k % n;

        // Step 2: Create a new array of the same size
        int[] newArray = new int[n];

        // Step 3: Calculate the new position for each element
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        // Step 4: Copy the values back into the original array
        for (int i = 0; i < n; i++) {
            nums[i] = newArray[i];
        }

        // Return the modified array as specified by the method signature
        return nums;
    }
}