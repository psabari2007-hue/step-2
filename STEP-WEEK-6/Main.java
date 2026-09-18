class HallTicket {
    String studentName;
    int seatNumber;

    // Constructor to initialize fields
    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class Main {
    public static void main(String[] args) {
        // 1. Create one HallTicket object for Priya
        HallTicket priya = new HallTicket("Priya", 0);
        
        // 2. Assign a second variable to point at that same object
        HallTicket copy = priya;
        
        // 3. Through the second variable, change seatNumber
        copy.seatNumber = 45;
        
        // 4. Print the field's value via first variable, and check if copy == priya
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        
        // 5. Create a third, separate object with identical field values, and check ==
        HallTicket separate = new HallTicket("Priya", 45);
        System.out.println("separate == priya: " + (separate == priya));
    }
}