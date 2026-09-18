public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Binary search loop
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Compare the middle element to the rightmost element
            if (nums[mid] > nums[right]) {
                // The minimum element must be in the right half
                left = mid + 1;
            } else {
                // The middle element itself or elements to its left could be the minimum
                right = mid;
            }
        }

        // left and right converge to the minimum element
        return nums[left];
    }
}