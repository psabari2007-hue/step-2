public class PlayerDraft {

    public static String findDuplicatePick(String[] playerNames) {
        // Outer loop scans each player from start to second to last
        for (int i = 0; i < playerNames.length; i++) {
            // Inner loop compares only against names that come AFTER the current player
            for (int j = i + 1; j < playerNames.length; j++) {
                // Perform case-sensitive string equality check
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        
        // Return this if the nested loops complete without finding duplicates
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        // Test Case 1
        String[] test1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println(findDuplicatePick(test1)); // Output: Duplicate Found: Kohli

        // Test Case 2
        String[] test2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println(findDuplicatePick(test2)); // Output: No Duplicates Found
    }
}