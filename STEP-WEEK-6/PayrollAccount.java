public class PayrollAccount {
    // Private instance variables for encapsulation
    private double basicSalary;
    private double bonus;

    // Public constructor with input validation
    public PayrollAccount(double openingBasicSalary) {
        if (openingBasicSalary < 0) {
            System.out.println("Warning: Opening basic salary cannot be negative. Setting to 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = openingBasicSalary;
        }
        this.bonus = 0; // Initialize bonus to 0
    }

    // Method to credit bonus with validation
    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Bonus amount must be greater than 0.");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    // Method to deduct tax percentage from basic salary
    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Error: Tax percentage must be between 0 and 100.");
        } else {
            this.basicSalary -= (this.basicSalary * (percent / 100.0));
            // Formats percent to strip trailing .0 if it's an integer, or prints as is
            System.out.println("Tax deducted: " + (percent == (int) percent ? String.valueOf((int) percent) : percent) + "%");
        }
    }

    // Read-only getter method for net salary
    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }

    // Main method to demonstrate and test the functionality matching the sample output
    public static void main(String[] args) {
        // Sample Input
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        
        // Output final net salary
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}