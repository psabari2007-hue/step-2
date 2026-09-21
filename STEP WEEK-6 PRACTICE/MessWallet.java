public class MessWallet {
    // Private balance field to prevent direct outside overwrite
    private double balance;

    // Constructor with input validation
    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Opening balance cannot be negative. Initializing to 0.0.");
            this.balance = 0.0;
        } else {
            this.balance = openingBalance;
        }
    }

    // Method to add funds
    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: Amount must be greater than zero.");
        } else {
            this.balance += amount;
            System.out.println("Balance after top-up: " + this.balance);
        }
    }

    // Method to deduct funds without going negative
    public void deduct(double amount) {
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            this.balance -= amount;
            System.out.println("Balance after deduction: " + this.balance);
        }
    }

    // Getter method for read-only access
    public double getBalance() {
        return this.balance;
    }

    // Main method to test the class behavior matching the sample output
    public static void main(String[] args) {
        // Sample Input / Output scenario
        MessWallet wallet = new MessWallet(500);
        
        wallet.topUp(200);
        wallet.deduct(1000);
        
        System.out.println("Final balance: " + wallet.getBalance());
    }
}