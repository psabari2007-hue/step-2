// Define the IdCard class
class IdCard {
    String name;
    int booksIssued;

    // Constructor to set name and booksIssued
    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class MainIdCard {
    public static void main(String[] args) {
        // 1. Create one IdCard object for Ravi
        IdCard ravi = new IdCard("Ravi", 0);

        // 2. Assign a second variable to point to that same object
        IdCard duplicate = ravi;

        // 3. Through the second variable, change booksIssued
        duplicate.booksIssued = 3;

        // 4. Print the field's value through the first variable and check if they are ==
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        // 5. Create a third, separate IdCard object with identical field values and compare
        IdCard separate = new IdCard("Ravi", 3);
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}