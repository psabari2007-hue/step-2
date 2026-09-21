import java.util.Random;

public class WellnessReport  {

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];
        
        Random random = new Random();

        // Populate arrays with realistic random values for a fast live demo
        for (int i = 0; i < teamSize; i++) {
            // Generates random heights between 1.50m and 1.95m
            heights[i] = 1.50 + (random.nextDouble() * 0.45);
            // Generates random weights between 50.0kg and 110.0kg
            weights[i] = 50.0 + (random.nextDouble() * 60.0);
        }

        // Print the complete formatted table
        printWellnessReport(heights, weights);
    }

    /**
     * Classifies the health status based on the calculated BMI value.
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Calculates BMI, determines status, and displays a clean, formatted table.
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        // Table Header
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s\n", 
                          "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("---------------------------------------------------------------");

        // Table Rows
        for (int i = 0; i < heights.length; i++) {
            double h = heights[i];
            double w = weights[i];
            
            // Formula: BMI = weight / (height * height)
            double bmi = w / (h * h);
            String status = getBmiStatus(bmi);

            // Display formatted output with 2 decimal places for floating-point numbers
            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-8.2f | %-12s\n", 
                              (i + 1), h, w, bmi, status);
        }
        System.out.println("---------------------------------------------------------------");
    }
}