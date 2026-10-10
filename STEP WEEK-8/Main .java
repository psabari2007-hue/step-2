import java.util.Scanner;

public class Main {

    // Enum representing different customer types and their specific pricing strategies
    enum CustomerType {
        STUDENT {
            @Override
            public double calculateFinalAmount(double amount) {
                return amount * 0.90; // 10% discount
            }
        },
        STAFF {
            @Override
            public double calculateFinalAmount(double amount) {
                return amount * 0.95; // 5% discount
            }
        },
        GUEST {
            @Override
            public double calculateFinalAmount(double amount) {
                return amount + 10.0; // Full amount + ₹10 service charge
            }
        };

        // Polymorphic method to be overridden by each customer type
        public abstract double calculateFinalAmount(double amount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String typeStr = scanner.next();
            double originalAmount = scanner.nextDouble();

            // Dynamically resolve the customer type without any if-else blocks
            CustomerType customerType = CustomerType.valueOf(typeStr.toUpperCase());
            
            // Execute the common operation polymorphically
            double finalAmount = customerType.calculateFinalAmount(originalAmount);
            grandTotal += finalAmount;

            // Display individual bill formatted to 2 decimal places
            System.out.printf("%s: %.2f\n", customerType.name(), finalAmount);
        }

        // Display the accumulated grand total
        System.out.printf("Total: %.2f\n", grandTotal);

        scanner.close();
    }
}