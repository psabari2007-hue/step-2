import java.util.Arrays;

public class ScoreBooster {

    // Modifies the caller's original array directly by adding the flat bonus
    public static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    // Example usage as shown in the problem statement
    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        int bonus = 10;

        // Modifies the original array in place
        curveScores(scores, bonus);

        // Prints the final leaderboard using Arrays.toString()
        System.out.println(Arrays.toString(scores)); 
        // Output: [80, 95, 70]
    }
}