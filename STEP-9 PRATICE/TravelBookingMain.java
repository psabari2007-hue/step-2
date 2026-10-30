import java.util.Scanner;

// Abstract base class to handle the shared booking fee
abstract class TravelBooking {
    // The common booking fee is defined in exactly one place
    protected static final double BOOKING_FEE = 50.0;
    protected double distanceKm;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    // Subclasses must implement their own unique base fare calculation
    public abstract double calculateBaseFare();

    // Shared logic to compute the final total fare
    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

// Subclass for Bus bookings
class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2.0 * distanceKm;
    }
}

// Subclass for Train bookings
class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 1.5 * distanceKm;
    }
}

// Subclass for Flight bookings
class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (4.0 * distanceKm);
    }
}

public class TravelBookingMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();
            
            TravelBooking booking = null;
            
            switch (mode) {
                case "BUS":
                    booking = new BusBooking(distance);
                    break;
                case "TRAIN":
                    booking = new TrainBooking(distance);
                    break;
                case "FLIGHT":
                    booking = new FlightBooking(distance);
                    break;
            }
            
            if (booking != null) {
                System.out.printf("%s: %.2f\n", mode, booking.calculateTotalFare());
            }
        }
        
        scanner.close();
    }
}