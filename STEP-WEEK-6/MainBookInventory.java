// Define the BookInventory class
class BookInventory {
    // Fields
    String title;
    String author;
    int copiesAvailable;

    // Constructor to initialize all fields
    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    // Instance method to print one formatted line
    public void printEntry() {
        System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
    }
}

// Main class to run the program
public class MainBookInventory {
    public static void main(String[] args) {
        // Create an array of BookInventory with 4 objects using the sample input
        BookInventory[] inventory = new BookInventory[4];
        
        inventory[0] = new BookInventory("Clean Code", "Robert C. Martin", 3);
        inventory[1] = new BookInventory("Effective Java", "Joshua Bloch", 5);
        inventory[2] = new BookInventory("Refactoring", "Martin Fowler", 0);
        inventory[3] = new BookInventory("Design Patterns", "GoF", 2);

        // Loop through the array and print each entry
        for (BookInventory book : inventory) {
            book.printEntry();
        }
    }
}