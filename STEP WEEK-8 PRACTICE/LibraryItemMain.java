import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract Base Class representing a generic Library Item
abstract class LibraryItem {
    private final String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    // Abstract method to be implemented by specific item types
    public abstract int getBorrowingPeriodDays();

    // Polymorphic method to calculate the due date
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(getBorrowingPeriodDays());
    }
}

// Concrete class for Books
class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    public int getBorrowingPeriodDays() {
        return 14;
    }
}

// Concrete class for DVDs
class Dvd extends LibraryItem {
    public Dvd(String title) {
        super(title);
    }

    @Override
    public int getBorrowingPeriodDays() {
        return 7;
    }
}

// Concrete class for Magazines
class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    public int getBorrowingPeriodDays() {
        return 3;
    }
}

// Factory class to handle object creation cleanly
class LibraryItemFactory {
    public static LibraryItem createItem(String type, String title) {
        switch (type.toUpperCase()) {
            case "BOOK":
                return new Book(title);
            case "DVD":
                return new Dvd(title);
            case "MAGAZINE":
                return new Magazine(title);
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }
}

public class LibraryItemMain {
    public static void main(String[] academiceg) {
        Scanner scanner = new Scanner(System.in);
        
        // Define base rules from the business logic
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        
        List<LibraryItem> borrowedItems = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                i--;
                continue;
            }
            
            // Split into ItemType and the rest of the line containing the quoted title
            int firstSpaceIndex = line.indexOf(' ');
            if (firstSpaceIndex != -1) {
                String type = line.substring(0, firstSpaceIndex);
                String titleWithQuotes = line.substring(firstSpaceIndex + 1).trim();
                
                // Remove the enclosing double quotes from the title
                String title = titleWithQuotes.replaceAll("^\"|\"$", "");
                
                borrowedItems.add(LibraryItemFactory.createItem(type, title));
            }
        }
        
        // Process and display all items uniformly using polymorphism
        for (LibraryItem item : borrowedItems) {
            LocalDate dueDate = item.calculateDueDate(currentDate);
            System.out.println(item.getTitle() + ": " + dueDate.format(formatter));
        }
        
        scanner.close();
    }
}