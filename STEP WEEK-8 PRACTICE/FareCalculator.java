import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class representing a transport strategy
abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
    public abstract String getTransportType();
}

// Bus implementation
class Bus extends Transport {
    public Bus(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.00 + (0.10 * distance);
        return Math.min(fare, 10.00); // Max fare cap of $10
    }

    @Override
    public String getTransportType() {
        return "BUS";
    }
}

// Train implementation
class Train extends Transport {
    public Train(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3.00 + (0.15 * distance);
    }

    @Override
    public String getTransportType() {
        return "TRAIN";
    }
}

// Metro implementation
class Metro extends Transport {
    private double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    @Override
    public String getTransportType() {
        return "METRO";
    }
}

// Main class to handle input and display output uniformly
public class FareCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Transport> journeys = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next().toUpperCase();
            double distance = scanner.nextDouble();
            
            switch (type) {
                case "BUS":
                    journeys.add(new Bus(distance));
                    break;
                case "TRAIN":
                    journeys.add(new Train(distance));
                    break;
                case "METRO":
                    double peakHourFactor = scanner.nextDouble();
                    journeys.add(new Metro(distance, peakHourFactor));
                    break;
                default:
                    break;
            }
        }
        
        double grandTotalFare = 0.0;
        
        // Processing the collection uniformly using polymorphism
        for (Transport journey : journeys) {
            double fare = journey.calculateFare();
            grandTotalFare += fare;
            System.out.printf("%s: %.2f\n", journey.getTransportType(), fare);
        }
        
        System.out.printf("\nTotal: %.2f\n", grandTotalFare);
        
        scanner.close();
    }
}