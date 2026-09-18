import java.util.HashMap;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        // Count of valid subarrays
        int count = 0; 
        // Running cumulative sum
        int currentSum = 0; 
        
        // Hash map to store frequency of encountered prefix sums
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        
        // Base case: A prefix sum of 0 has occurred exactly once (before any elements are added)
        prefixSumMap.put(0, 1);
        
        for (int num : nums) {
            // Update the running prefix sum
            currentSum += num;
            
            // Check if (currentSum - k) exists in our map
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }
            
            // Record the current prefix sum in the map
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}