import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

// Abstract base class representing a generic delivery request
abstract class DeliveryRequest {
    private final String type;
    protected final double weight;
    protected final double distance;

    public DeliveryRequest(String type, double weight, double distance) {
        this.type = type;
        this.weight = weight;
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    // Abstract method to be implemented by each specific delivery type
    public abstract double calculateFee();
}

// Standard Delivery Implementation
class StandardDelivery extends DeliveryRequest {
    public StandardDelivery(double weight, double distance) {
        super("STANDARD", weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5.00 + (weight * 0.50) + (distance * 0.10);
    }
}

// Express Delivery Implementation
class ExpressDelivery extends DeliveryRequest {
    public ExpressDelivery(double weight, double distance) {
        super("EXPRESS", weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15.00 + (weight * 2.00) + (distance * 0.20);
    }
}

// International Delivery Implementation
class InternationalDelivery extends DeliveryRequest {
    private final double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super("INTERNATIONAL", weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25.00 + (weight * 2.50) + (distance * 0.50) + customsFee;
    }
}

// Main System to process all requests uniformly
public class DeliveryRequestMain {
    public static void main(String[] args) {
        // Use Locale.US to ensure uniform decimal formatting with '.'
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<DeliveryRequest> deliveries = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next().toUpperCase();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            
            switch (type) {
                case "STANDARD":
                    deliveries.add(new StandardDelivery(weight, distance));
                    break;
                case "EXPRESS":
                    deliveries.add(new ExpressDelivery(weight, distance));
                    break;
                case "INTERNATIONAL":
                    double customsFee = scanner.nextDouble();
                    deliveries.add(new InternationalDelivery(weight, distance, customsFee));
                    break;
            }
        }
        
        double grandTotal = 0.0;
        
        // Uniform calculation without explicit type-checking at runtime (Polymorphism)
        for (DeliveryRequest delivery : deliveries) {
            double fee = delivery.calculateFee();
            grandTotal += fee;
            System.out.printf("%s: %.2f\n", delivery.getType(), fee);
        }
        
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}