import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage; // Acts as the fantasy points metric
    private boolean injured;

    // Constructor
    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Overloaded Method 1: Experience-only rule
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Overloaded Method 2: Combined matches-and-fitness rule
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    // Comparable Implementation: Ranks descending by fantasy points (batting average)
    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    // Main draft and rank processing logic
    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        List<Player> draftableList = new ArrayList<>();

        // Filter out draftable players based on rules
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftableList.add(p);
            }
        }

        // Convert to array to satisfy the requirement: "a plain Arrays.sort(draftableArray) does the entire ranking"
        Player[] draftableArray = draftableList.toArray(new Player[0]);
        Arrays.sort(draftableArray);

        // Build the formatted output string
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            output.append(i + 1).append(". ").append(draftableArray[i].name);
            if (i < draftableArray.length - 1) {
                output.append(" | ");
            }
        }

        return output.toString();
    }
}