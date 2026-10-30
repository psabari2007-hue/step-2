import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class representing a generic connection
abstract class Connection {
    protected int units;

    public Connection(int units) {
        this.units = units;
    }

    // Abstract method to be implemented by each connection type
    public abstract double calculateBill();
}

// Home connection subclass
class HomeConnection extends Connection {
    public HomeConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
}

// Shop connection subclass
class ShopConnection extends Connection {
    public ShopConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

// Factory connection subclass
class FactoryConnection extends Connection {
    public FactoryConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        double rawBill = units * 6.0;
        return Math.max(rawBill, 1000.0); // Ensures a minimum bill of 1000
    }
}

public class ConnectionMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<String> connectionTypes = new ArrayList<>();
        List<Connection> connections = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            
            connectionTypes.add(type);
            
            switch (type) {
                case "HOME":
                    connections.add(new HomeConnection(units));
                    break;
                case "SHOP":
                    connections.add(new ShopConnection(units));
                    break;
                case "FACTORY":
                    connections.add(new FactoryConnection(units));
                    break;
                default:
                    break;
            }
        }
        
        double totalAmount = 0.0;
        
        // Output the bill for each connection and calculate total
        for (int i = 0; i < connections.size(); i++) {
            double bill = connections.get(i).calculateBill();
            totalAmount += bill;
            System.out.printf("%s: %.2f\n", connectionTypes.get(i), bill);
        }
        
        // Output total bill
        System.out.printf("Total: %.2f\n", totalAmount);
        
        scanner.close();
    }
}