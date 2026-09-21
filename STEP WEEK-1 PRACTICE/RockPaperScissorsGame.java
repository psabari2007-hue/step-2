import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    // Method to determine the winner of a single round
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalRounds = 5;
        String[] moves = {"Rock", "Paper", "Scissors"};
        
        // Arrays to store history for the final summary table
        String[] playerHistory = new String[totalRounds];
        String[] computerHistory = new String[totalRounds];
        String[] resultHistory = new String[totalRounds];
        
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("--- Welcome to the College Coding Arcade: Rock-Paper-Scissors ---");

        // Game loop for N rounds
        for (int i = 0; i < totalRounds; i++) {
            System.out.println("\n--- Round " + (i + 1) + " ---");
            
            // 1. Get Player Move with validation
            String playerMove = "";
            while (true) {
                System.out.print("Enter your move (Rock, Paper, Scissors): ");
                playerMove = scanner.nextLine().trim();
                if (playerMove.equalsIgnoreCase("Rock") || 
                    playerMove.equalsIgnoreCase("Paper") || 
                    playerMove.equalsIgnoreCase("Scissors")) {
                    break;
                }
                System.out.println("Invalid move! Please try again.");
            }
            
            // Standardize format to Capitalized (e.g., "rock" -> "Rock")
            playerMove = playerMove.substring(0, 1).toUpperCase() + playerMove.substring(1).toLowerCase();

            // 2. Generate Computer Move randomly
            int randomIndex = random.nextInt(3);
            String computerMove = moves[randomIndex];

            // 3. Play the round and determine outcome
            String result = playRound(playerMove, computerMove);
            System.out.println("Computer chose: " + computerMove);
            System.out.println("Result: " + result);

            // 4. Update counters
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            // 5. Save data for the final summary table
            playerHistory[i] = playerMove;
            computerHistory[i] = computerMove;
            resultHistory[i] = result;
        }

        // Calculate Win Percentage
        double winPercentage = ((double) wins / totalRounds) * 100;

        // Print final summary table
        System.out.println("\n=======================================================");
        System.out.println("                   FINAL SUMMARY                       ");
        System.out.println("=======================================================");
        System.out.printf("%-10s | %-12s | %-13s | %-15s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-------------------------------------------------------");
        
        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("Round %-4d | %-12s | %-13s | %-15s\n", 
                    (i + 1), playerHistory[i], computerHistory[i], resultHistory[i]);
        }
        
        System.out.println("=======================================================");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", 
                wins, losses, draws, winPercentage);
        System.out.println("=======================================================");

        scanner.close();
    }
}