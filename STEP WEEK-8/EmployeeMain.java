import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class representing a generic employee
abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    // Abstract method to be implemented by each specific employee type
    public abstract double calculateBonus();
}

// Full-time employee implementation
class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return this.monthlySalary * 0.10; // 10% of monthly salary
    }
}

// Part-time employee implementation
class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return this.monthlySalary * 0.05; // 5% of monthly salary
    }
}

// Intern implementation
class InternEmployee extends Employee {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 2000.00; // Fixed bonus of ₹2,000
    }
}

// Main class to process the payroll calculation
public class EmployeeMain {
    public static void main(String[] academicelement) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Employee> employees = new ArrayList<>();
        
        // Read input and instantiate the correct subclass objects
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();
            
            switch (type) {
                case "FULLTIME":
                    employees.add(new FullTimeEmployee(name, salary));
                    break;
                case "PARTTIME":
                    employees.add(new PartTimeEmployee(name, salary));
                    break;
                case "INTERN":
                    employees.add(new InternEmployee(name, salary));
                    break;
            }
        }
        
        double totalGrandBonus = 0.0;
        
        // Polymorphic processing: Calculates bonus without explicit type checking
        for (Employee emp : employees) {
            double bonus = emp.calculateBonus();
            System.out.printf("%s: %.2f\n", emp.getName(), bonus);
            totalGrandBonus += bonus;
        }
        
        System.out.printf("Total Bonus: %.2f\n", totalGrandBonus);
        
        scanner.close();
    }
}