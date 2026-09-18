import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] threeSum(int[] nums) {
        List<int[]> resultList = new ArrayList<>();
        
        // Step 1: Sort the array first as required
        Arrays.sort(nums);
        
        // Step 2: Iterate through the array for the first element
        for (int i = 0; i < nums.length - 2; i++) {
            // Avoid duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Step 3: Initialize two pointers for the remaining subarray
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Found a valid triplet
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});
                    
                    // Carefully skip over duplicate values for left and right pointers
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // Move pointers inward after processing the current match
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Sum is too low, move the left pointer to increase the sum
                    left++;
                } else {
                    // Sum is too high, move the right pointer to decrease the sum
                    right--;
                }
            }
        }
        
        // Convert the List<int[]> back to the requested 2D primitive array format: int[][]
        return resultList.toArray(new int[resultList.size()][]);
    }
}