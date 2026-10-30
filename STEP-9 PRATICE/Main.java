import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// --- Polymorphic Base Component ---
abstract class Plot {
    private final String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    // Abstract methods to be overridden by specific shapes
    public abstract String getShapeName();
    public abstract double calculateArea();

    // Standardized report line formatting for any shape
    public void printReportLine() {
        System.out.printf("%s (%s): %.2f%n", owner, getShapeName(), calculateArea());
    }
}

// --- Concrete Shape Implementations ---
class Circle extends Plot {
    private final double radius;

    public Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return "CIRCLE";
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Plot {
    private final double length;
    private final double width;

    public Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public String getShapeName() {
        return "RECTANGLE";
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class Triangle extends Plot {
    private final double base;
    private final double height;

    public Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return "TRIANGLE";
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// --- Main Program ---
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Plot> plots = new ArrayList<>();

        // Process inputs and instantiate specific shapes polmorphicly
        for (int i = 0; i < n; i++) {
            String shapeType = scanner.next();
            String owner = scanner.next();

            switch (shapeType.toUpperCase()) {
                case "CIRCLE":
                    double radius = scanner.nextDouble();
                    plots.add(new Circle(owner, radius));
                    break;
                case "RECTANGLE":
                    double length = scanner.nextDouble();
                    double width = scanner.nextDouble();
                    plots.add(new Rectangle(owner, length, width));
                    break;
                case "TRIANGLE":
                    double base = scanner.nextDouble();
                    double height = scanner.nextDouble();
                    plots.add(new Triangle(owner, base, height));
                    break;
                default:
                    System.out.println("Unknown shape type: " + shapeType);
                    break;
            }
        }
        scanner.close();

        // Generate Report (This block remains unchanged even if new shapes are added)
        double totalArea = 0.0;
        for (Plot plot : plots) {
            plot.printReportLine();
            totalArea += plot.calculateArea();
        }
        
        System.out.printf("Total Area: %.2f%n", totalArea);
    }
}