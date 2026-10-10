import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class representing a generic Room
abstract class Room {
    protected String roomType;
    protected int units;

    public Room(String roomType, int units) {
        this.roomType = roomType;
        this.units = units;
    }

    public String getRoomType() {
        return roomType;
    }

    // Abstract method to be implemented by each specific room type
    public abstract double calculateBill();
}

// Single Room implementation
class SingleRoom extends Room {
    public SingleRoom(int units) {
        super("SINGLE", units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0;
    }
}

// Shared Room implementation
class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super("SHARED", units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

// AC Room implementation
class ACRoom extends Room {
    public ACRoom(int units) {
        super("AC", units);
    }

    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }
}

public class RoomMain {
    public static void main(String[] academice) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Room> rooms = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            
            switch (type) {
                case "SINGLE":
                    rooms.add(new SingleRoom(units));
                    break;
                case "SHARED":
                    int occupants = scanner.nextInt();
                    rooms.add(new SharedRoom(units, occupants));
                    break;
                case "AC":
                    rooms.add(new ACRoom(units));
                    break;
            }
        }
        
        double grandTotal = 0.0;
        
        // Process each room through polymophism
        for (Room room : rooms) {
            double bill = room.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f\n", room.getRoomType(), bill);
        }
        
        System.out.printf("Total: %.2f\n", grandTotal);
        
        scanner.close();
    }
}