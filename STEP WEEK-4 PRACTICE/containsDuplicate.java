public boolean containsDuplicate(int[] nums) {
    // Outer loop picks the first element of the pair
    for (int i = 0; i < nums.length; i++) {
        // Inner loop picks the second element of the pair
        // Starting j from i + 1 avoids checking duplicates twice or comparing an element with itself
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                return true; // Early exit once a duplicate is found
            }
        }
    }
    return false; // Return false if no duplicate pairs exist
}