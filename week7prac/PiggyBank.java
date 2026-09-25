public class PiggyBank {
    // Requirements: Private savings amount and a final fixed ID
    private final String id;
    private int savings;

    // Constructor: Initializes the unique ID and sets starting savings to 0
    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0; 
    }

    // Adds exactly the specified amount to the savings
    public void deposit(int amount) {
        if (amount > 0) {
            this.savings += amount;
        }
    }

    // Rejects the transaction if the withdrawal is larger than current savings
    public void withdraw(int amount) {
        if (amount > this.savings) {
            System.out.println("Transaction rejected: Insufficient savings.");
            return;
        }
        this.savings -= amount;
    }

    // Provides a way to check current savings without allowing direct modification
    public int getSavings() {
        return this.savings;
    }

    // Getter for the fixed ID
    public String getId() {
        return this.id;
    }
}