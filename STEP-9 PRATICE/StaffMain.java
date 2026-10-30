import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class to prevent direct instantiation
abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method forces subclasses to define their own pay calculation
    public abstract double calculatePay();
}

// FullTime subclass
class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

// Hourly subclass
class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * 1.5 * rate);
        }
    }
}

// Intern subclass
class InternStaff extends Staff {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

// Main class to handle input and output
public class StaffMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Staff> staffList = new ArrayList<>();
        double totalPayroll = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            switch (type) {
                case "FULLTIME":
                    double salary = scanner.nextDouble();
                    staffList.add(new FullTimeStaff(name, salary));
                    break;
                case "HOURLY":
                    double hours = scanner.nextDouble();
                    double rate = scanner.nextDouble();
                    staffList.add(new HourlyStaff(name, hours, rate));
                    break;
                case "INTERN":
                    double stipend = scanner.nextDouble();
                    staffList.add(new InternStaff(name, stipend));
                    break;
            }
        }

        // Print individual pay and calculate total
        for (Staff staff : staffList) {
            double pay = staff.calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f\n", staff.getName(), pay);
        }

        // Print total payroll
        System.out.printf("Total Payroll: %.2f\n", totalPayroll);
        
        scanner.close();
    }
}