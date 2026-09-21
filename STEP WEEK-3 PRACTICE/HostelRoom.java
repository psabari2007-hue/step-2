// Define the HostelRoom class with the requested fields
class HostelRoom {
    String roomNo;
    int occupied;

    // Constructor to initialize the room number
    public HostelRoom(String roomNo) {
        this.roomNo = roomNo;
        this.occupied = 0; // Starts at 0 by default
    }
}

public class Main {
    public static void main(String[] args) {
        // 1. Create two HostelRoom objects with different roomNo values
        HostelRoom roomA = new HostelRoom("C-101");
        HostelRoom roomB = new HostelRoom("C-102");

        // 2. Increase occupied for roomA only, three separate times
        roomA.occupied++;
        roomA.occupied++;
        roomA.occupied++;

        // 3. Print both rooms' occupied values to show roomB was never touched
        System.out.println(roomA.roomNo + " occupied: " + roomA.occupied);
        System.out.println(roomB.roomNo + " occupied: " + roomB.occupied);
    }
}