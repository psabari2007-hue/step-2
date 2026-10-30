import java.util.Scanner;

// Abstract base class representing a generic library item
abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    // Abstract method to be implemented by specific item types
    public abstract double calculateFine();
}

// Book class implementation
class Book extends LibraryItem {
    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

// DVD class implementation with a maximum fine cap
class DVD extends LibraryItem {
    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        double fine = daysLate * 5.0;
        return Math.min(fine, 50.0); // Maximum fine capped at 50
    }
}

// Magazine class implementation
class Magazine extends LibraryItem {
    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class LibraryItemMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        int n = scanner.nextInt();
        double totalFines = 0.0;
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();
            
            LibraryItem item = null;
            
            // Factory logic to instantiate the appropriate class
            switch (type) {
                case "BOOK":
                    item = new Book(title, daysLate);
                    break;
                case "DVD":
                    item = new DVD(title, daysLate);
                    break;
                case "MAGAZINE":
                    item = new Magazine(title, daysLate);
                    break;
            }
            
            if (item != null) {
                double fine = item.calculateFine();
                System.out.printf("%s: %.2f\n", item.getTitle(), fine);
                totalFines += fine;
            }
        }
        
        System.out.printf("Total Fines: %.2f\n", totalFines);
        scanner.close();
    }
}