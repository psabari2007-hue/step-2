public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
    // Create a new empty result array with the combined length of both input arrays
    int[] result = new int[arr1.length + arr2.length];
    
    // Keep one index pointer for each array, starting at 0
    int i = 0; // Pointer for arr1
    int j = 0; // Pointer for arr2
    int k = 0; // Pointer for result array
    
    // Repeatedly compare elements and copy the smaller one into the result array
    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] <= arr2[j]) {
            result[k] = arr1[i];
            i++;
        } else {
            result[k] = arr2[j];
            j++;
        }
        k++;
    }
    
    // Copy any remaining elements from arr1 onto the end of the result
    while (i < arr1.length) {
        result[k] = arr1[i];
        i++;
        k++;
    }
    
    // Copy any remaining elements from arr2 onto the end of the result
    while (j < arr2.length) {
        result[k] = arr2[j];
        j++;
        k++;
    }
    
    // Return the fully merged, fully sorted result array
    return result;
}