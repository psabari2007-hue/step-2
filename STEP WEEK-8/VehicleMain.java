import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Abstract Base Class representing a Vehicle
abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    // Abstract method to be overridden by specific vehicle types
    public abstract double calculateCharge();
}

// Bike implementation
class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return hours * 10.0;
    }
}

// Car implementation
class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        if (hours <= 0) return 0.0;
        return 30.0 + (hours - 1) * 20.0;
    }
}

// Truck implementation
class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        double baseCharge = hours * 50.0;
        return Math.max(baseCharge, 100.0); // Minimum charge of ₹100
    }
}

// Factory Pattern to handle Vehicle creation cleanly
class VehicleFactory {
    public static Vehicle createVehicle(String type, int hours) {
        switch (type.toUpperCase()) {
            case "BIKE":
                return new Bike(hours);
            case "CAR":
                return new Car(hours);
            case "TRUCK":
                return new Truck(hours);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}

// Main Class
public class VehicleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        double grandTotal = 0.0;
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            
            try {
                // Polymorphic creation and computation
                Vehicle vehicle = VehicleFactory.createVehicle(type, hours);
                double charge = vehicle.calculateCharge();
                grandTotal += charge;
                
                System.out.printf("%s: %.2f\n", type.toUpperCase(), charge);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}