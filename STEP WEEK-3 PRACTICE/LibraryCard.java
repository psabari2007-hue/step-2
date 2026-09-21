class LibraryCard {
    String holderName;
    int booksIssued;
    boolean active;
}

public class Main {
    public static void main(String[] args) {
        // Create one LibraryCard object without setting any fields
        LibraryCard card = new LibraryCard();

        // Print all three fields immediately to observe default values
        System.out.println("Holder: " + card.holderName);
        System.out.println("Books Issued: " + card.booksIssued);
        System.out.println("Active: " + card.active);
    }
}