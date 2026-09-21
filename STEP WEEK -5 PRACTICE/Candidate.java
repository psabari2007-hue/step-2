import java.util.Arrays;

public class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;

    // Constructor as specified in the function signatures
    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // 1. Quick filter: A strong CGPA alone is enough (e.g., >= 7.0)
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    // 2. Combined filter: Borderline CGPA but with a genuinely good coding score
    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    // Calculates the composite score used for ranking
    public double getCompositeScore() {
        return (this.cgpa * 10) + this.codingScore;
    }

    // 3. Compare candidates descending by composite score
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    // 4. Shortlist eligible candidates and rank them using Arrays.sort
    public static String shortlistAndRank(Candidate[] candidates) {
        // Step 1: Filter and find how many candidates are eligible
        Candidate[] temp = new Candidate[candidates.length];
        int count = 0;
        
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                temp[count++] = c;
            }
        }
        
        // Step 2: Copy to a perfectly sized array
        Candidate[] eligibleCandidates = Arrays.copyOf(temp, count);
        
        // Step 3: Sort using Java's built-in sort (uses compareTo automatically)
        Arrays.sort(eligibleCandidates);
        
        // Step 4: Build the required output string format
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < eligibleCandidates.length; i++) {
            Candidate c = eligibleCandidates[i];
            result.append(i + 1).append(". ")
                  .append(c.name).append(" (")
                  .append(c.getCompositeScore()).append(")");
            
            if (i < eligibleCandidates.length - 1) {
                result.append(" | ");
            }
        }
        
        return result.toString();
    }
}