public class StudentRecordParser {

    public static void parseStudentRecord(String csvLine) {
        // Break the CSV line into fields using the comma delimiter
        String[] fields = csvLine.split(",");

        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        // Trim whitespace from fields to ensure neat formatting
        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String dept = fields[2].trim();

        // Print the formatted output
        System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Dept: " + dept);
    }

    // Main method to test the logic with sample inputs
    public static void main(String[] args) {
        // Test case 1: Valid input matching the sample
        String sampleInput = "Ananya Verma,RA2211003010123,CSE";
        parseStudentRecord(sampleInput);

        // Test case 2: Invalid input (missing field)
        String invalidInput = "John Doe,RA2211003010124";
        parseStudentRecord(invalidInput);
    }
}