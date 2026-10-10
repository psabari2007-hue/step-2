import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Solution {

    // Define the subscription plans using an Enum to encapsulate validity logic
    enum PlanType {
        BASIC(30),
        STANDARD(90),
        PREMIUM(365);

        private final int validityDays;

        PlanType(int validityDays) {
            this.validityDays = validityDays;
        }

        // Common operation implemented polymorphically without type checking
        public LocalDate calculateRenewalDate(LocalDate startDate) {
            return startDate.plusDays(this.validityDays);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            // Read input fields
            String planStr = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();

            // Parse inputs into structured objects
            PlanType plan = PlanType.valueOf(planStr.toUpperCase());
            LocalDate startDate = LocalDate.parse(dateStr, formatter);

            // Compute the renewal date using polymorphism
            LocalDate renewalDate = plan.calculateRenewalDate(startDate);

            // Print the required format
            System.out.println(name + ": " + renewalDate.format(formatter));
        }

        scanner.close();
    }
}