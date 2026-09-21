static String findDuplicateTeam(String[] teamNames) {
    // Outer loop selects a name to compare
    for (int i = 0; i < teamNames.length; i++) {
        // Inner loop compares it only against the names that come after it
        for (int j = i + 1; j < teamNames.length; j++) {
            // Case-sensitive comparison
            if (teamNames[i].equals(teamNames[j])) {
                return "Duplicate Found: " + teamNames[i];
            }
        }
    }
    // Returned if no matching duplicates are found after checking all pairs
    return "No Duplicates Found";
}