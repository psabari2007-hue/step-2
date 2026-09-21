// Define the PlacementRecord class
class PlacementRecord {
    // Fields
    String studentName;
    String company;
    double packageLpa;

    // Constructor to initialize all fields
    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    // Instance method to print the formatted record
    public void printRecord() {
        System.out.printf("%s -> %s @ %.1f LPA%n", studentName, company, packageLpa);
    }
}

// Main class to execute and test the implementation
public class Main {
    public static void main(String[] args) {
        // Create three PlacementRecord objects with sample data
        PlacementRecord record1 = new PlacementRecord("Ravi", "TCS", 4.5);
        PlacementRecord record2 = new PlacementRecord("Anitha", "Zoho", 6.2);
        PlacementRecord record3 = new PlacementRecord("Karthik", "Infosys", 4.0);

        // Store the objects inside an array of PlacementRecord
        PlacementRecord[] placementRecords = {record1, record2, record3};

        // Loop through the array and print each record
        for (PlacementRecord record : placementRecords) {
            record.printRecord();
        }
    }
}