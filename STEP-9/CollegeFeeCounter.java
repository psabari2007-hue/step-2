import java.util.Scanner;

// Base class representing a general student
abstract class Student {
    protected String name;
    protected static final double TRANSPORT_FEE = 12000.00;

    public Student(String name) {
        this.name = name;
    }

    public abstract double getBaseTuition();
    
    // Default implementation assumes the student uses the bus
    public boolean usesBus() {
        return true;
    }

    public double calculateTotalFee() {
        double total = getBaseTuition();
        if (usesBus()) {
            total += TRANSPORT_FEE;
        }
        return total;
    }

    public String getName() {
        return name;
    }
}

// Day Scholar class
class DayScholar extends Student {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double getBaseTuition() {
        return 40000.00;
    }
}

// Hosteller class
class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double getBaseTuition() {
        return 40000.00 + 60000.00; // Tuition + Hostel fee
    }

    @Override
    public boolean usesBus() {
        return false; // Hostellers live on campus and do not use the bus
    }
}

// Scholarship Student class
class Scholar extends Student {
    public Scholar(String name) {
        super(name);
    }

    @Override
    public double getBaseTuition() {
        return 20000.00; // Half of normal tuition
    }
}

// Main execution class
public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.class);
        
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        double totalCollected = 0.0;
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            
            Student student = null;
            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new Scholar(name);
                    break;
                default:
                    break;
            }
            
            if (student != null) {
                double studentFee = student.calculateTotalFee();
                System.out.printf("%s: %.2f\n", student.getName(), studentFee);
                totalCollected += studentFee;
            }
        }
        
        System.out.printf("Total Collected: %.2f\n", totalCollected);
        scanner.close();
    }
}