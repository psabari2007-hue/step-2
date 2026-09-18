public class Employee2 {
    // Instance fields unique to each employee
    private String empName;
    private double salary;

    // Static fields shared by all employee objects
    private static String companyName = "Bright Horizon Technologies";
    private static int employeeCount = 0;

    // Constructor that increments employeeCount every time a new object is created
    public Employee2(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++; 
    }

    // Static method to print company details and the current total count
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    // Main method to run and demonstrate the solution
    public static void main(String[] args) {
        // Task: Create three Employee objects
        Employee2 emp1 = new Employee2("Alice", 75000);
        Employee2 emp2 = new Employee2("Bob", 80000);
        Employee2 emp3 = new Employee2("Charlie", 68000);

        // Task: Call printCompanyInfo() through the class name
        Employee2.printCompanyInfo();
    }
}