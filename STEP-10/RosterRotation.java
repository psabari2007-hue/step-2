import java.util.Arrays;

public class RosterRotation {

    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        
        // Handle edge cases: empty array or single element
        if (n <= 1) {
            return names.clone();
        }

        // Reduce k to remove redundant full rotations
        k = k % n;

        String[] rotated = new String[n];

        // Move each name at index i to its new position (i + k) % n
        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            rotated[newIndex] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        // Test Sample 1
        String[] names1 = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names1, 2))); 
        // Expected Output: [D, E, A, B, C]

        // Test Sample 2
        String[] names2 = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names2, 7))); 
        // Expected Output: [D, E, A, B, C]
    }
}