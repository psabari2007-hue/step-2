import java.util.Scanner;

public class MovieTicketCounter {
    // The convenience fee is written in one place only as a constant
    private static final double CONVENIENCE_FEE = 20.00;
    
    // Seat price constants
    private static final double REGULAR_PRICE = 150.00;
    private static final double PREMIUM_PRICE = 250.00;
    private static final double RECLINER_PRICE = 400.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of bookings
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        double totalCollected = 0.0;
        
        // Process each booking
        for (int i = 0; i < n; i++) {
            String seatType = scanner.next();
            int count = scanner.nextInt();
            
            double basePrice = 0.0;
            
            // Determine price based on seat type
            switch (seatType.toUpperCase()) {
                case "REGULAR":
                    basePrice = REGULAR_PRICE;
                    break;
                case "PREMIUM":
                    basePrice = PREMIUM_PRICE;
                    break;
                case "RECLINER":
                    basePrice = RECLINER_PRICE;
                    break;
                default:
                    // Invalid seat type skipped
                    continue;
            }
            
            // Calculate total for this booking: (base price + fee) * number of tickets
            double bookingAmount = (basePrice + CONVENIENCE_FEE) * count;
            totalCollected += bookingAmount;
            
            // Output booking result formatted to 2 decimal places
            System.out.printf("%s: %.2f%n", seatType, bookingAmount);
        }
        
        // Output final total formatted to 2 decimal places
        System.out.printf("Total: %.2f%n", totalCollected);
        
        scanner.close();
    }
}