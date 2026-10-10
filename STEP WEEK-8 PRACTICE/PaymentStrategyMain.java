import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface defining uniform behavior for all payment methods
interface PaymentStrategy {
    double calculateFinalAmount(double amount);
}

// Concrete implementation for Card payments (2% fee)
class CardPayment implements PaymentStrategy {
    @Override
    public double calculateFinalAmount(double amount) {
        return amount * 1.02;
    }
}

// Concrete implementation for Wallet payments (1% fee)
class WalletPayment implements PaymentStrategy {
    @Override
    public double calculateFinalAmount(double amount) {
        return amount * 1.01;
    }
}

// Concrete implementation for Bank Transfers (0% fee)
class BankTransferPayment implements PaymentStrategy {
    @Override
    public double calculateFinalAmount(double amount) {
        return amount;
    }
}

// Factory to create the correct strategy without conditional checks in the main flow
class PaymentFactory {
    public static PaymentStrategy getStrategy(String type) {
        switch (type.toUpperCase()) {
            case "CARD":
                return new CardPayment();
            case "WALLET":
                return new WalletPayment();
            case "BANKTRANSFER":
                return new BankTransferPayment();
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }
}

// Class representing a uniform transaction processing unit
class Transaction {
    private final String type;
    private final double amount;
    private final PaymentStrategy strategy;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.strategy = PaymentFactory.getStrategy(type);
    }

    public double getAdjustedAmount() {
        return strategy.calculateFinalAmount(amount);
    }

    public void display() {
        System.out.printf("%s: %.2f\n", type, getAdjustedAmount());
    }
}

public class PaymentStrategyMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Transaction> transactions = new ArrayList<>();
        
        // Read input uniformly
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            transactions.add(new Transaction(type, amount));
        }
        
        double grandTotal = 0.0;
        
        // Process and display uniformly without explicit type checking
        for (Transaction transaction : transactions) {
            transaction.display();
            grandTotal += transaction.getAdjustedAmount();
        }
        
        System.out.printf("\nTotal: %.2f\n", grandTotal);
        scanner.close();
    }
}