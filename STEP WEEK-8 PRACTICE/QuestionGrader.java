import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuestionGrader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            return;
        }
        
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the first line
        
        double totalScore = 0.0;
        
        // Regex pattern to capture: Type "Question" "Correct" "Student" Points
        Pattern pattern = Pattern.compile("^(\\S+)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+)$");
        
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                i--; // Skip empty lines if any
                continue;
            }
            
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                String type = matcher.group(1);
                String questionText = matcher.group(2);
                String correctAnswer = matcher.group(3);
                String studentAnswer = matcher.group(4);
                int points = Integer.parseInt(matcher.group(5));
                
                double score = 0.0;
                
                if (type.equals("MCQ") || type.equals("TF")) {
                    // Full points if StudentAnswer exactly matches CorrectAnswer
                    if (studentAnswer.equals(correctAnswer)) {
                        score = points;
                    }
                } else if (type.equals("ESSAY")) {
                    // Split the keywords by comma and trim whitespaces
                    String[] keywords = correctAnswer.split(",");
                    int matchCount = 0;
                    
                    String studentAnswerLower = studentAnswer.toLowerCase();
                    
                    for (String keyword : keywords) {
                        String trimmedKeyword = keyword.trim().toLowerCase();
                        if (!trimmedKeyword.isEmpty() && studentAnswerLower.contains(trimmedKeyword)) {
                            matchCount++;
                        }
                    }
                    
                    // Award partial points based on matches
                    if (matchCount >= 2) {
                        score = points * 0.75;
                    } else if (matchCount == 1) {
                        score = points * 0.50;
                    } else {
                        score = 0.0;
                    }
                }
                
                // Print individual question score formatted to 2 decimal places
                System.out.printf("%s: %.2f\n", type, score);
                totalScore += score;
            }
        }
        
        // Print total score formatted to 2 decimal places
        System.out.printf("Total Score: %.2f\n", totalScore);
        
        scanner.close();
    }
}