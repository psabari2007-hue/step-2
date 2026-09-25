public class Scorecard {
    // Hint 1: The array exists only inside the class (private)
    private final boolean[] results;
    
    // Hint 2: A separate counter to track answers recorded so far
    private int answersRecorded;

    // Constructor: The total number of questions is fixed upon creation
    public Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.answersRecorded = 0;
    }

    // Method to record the next answer's result
    public void recordAnswer(boolean isCorrect) {
        // Ignore or reject if trying to record more than the fixed count
        if (answersRecorded < results.length) {
            results[answersRecorded] = isCorrect;
            answersRecorded++; // Move the pointer to the next slot
        }
    }

    // Method to calculate and return the total score
    // Exposes only the integer count—never the array itself
    public int getScore() {
        int score = 0;
        for (int i = 0; i < answersRecorded; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }
}