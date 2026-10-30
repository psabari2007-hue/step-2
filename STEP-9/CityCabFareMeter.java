import java.util.Scanner;

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of trips
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        double totalFare = 0.0;

        // Process each trip
        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double distance = scanner.nextDouble();
            String timeOfDay = scanner.next();

            // 1. Check night service availability for MINI
            if (cabType.equals("MINI") && timeOfDay.equals("NIGHT")) {
                System.out.println("MINI: night service not available");
                continue; 
            }

            // 2. Determine base rate per kilometer
            double ratePerKm = 0.0;
            switch (cabType) {
                case "MINI":  ratePerKm = 10.0; break;
                case "SEDAN": ratePerKm = 14.0; break;
                case "SUV":   ratePerKm = 18.0; break;
            }

            // 3. Calculate distance fare and apply the minimum fare rule (100.00)
            double fare = distance * ratePerKm;
            if (fare < 100.00) {
                fare = 100.00;
            }

            // 4. Apply night service surcharge if applicable (20% extra)
            if (timeOfDay.equals("NIGHT")) {
                fare *= 1.20;
            }

            // Print the current trip fare formatted to two decimal places
            System.out.printf("%s: %.2f\n", cabType, fare);

            // Add to the total of completed trips
            totalFare += fare;
        }

        // Print final grand total formatted to two decimal places
        System.out.printf("Total: %.2f\n", totalFare);
        
        scanner.close();
    }
}