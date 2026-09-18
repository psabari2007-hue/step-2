public class Employee {
    // 1. Define fields
    private String empId;
    private String empName;
    private double salary;
    private boolean isIntern;

    // 2. Three-argument constructor for permanent employees
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // 3. Two-argument constructor for interns using constructor chaining
    public Employee(String empId, String empName) {
        this(empId, empName, 0.0); // Chains via this(...)
        this.isIntern = true;      // Sets isIntern to true afterwards
    }

    // 4. Method to print profile fields on one line
    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    // 5. Main method to demonstrate functionality
    public static void main(String[] args) {
        // Create permanent employee
        Employee permanentEmp = new Employee("E-101", "Divya", 65000.0);
        permanentEmp.printProfile();

        // Create intern employee
        Employee internEmp = new Employee("E-102", "Arjun");
        internEmp.printProfile();
    }
}