public class AttendanceSheet {
    // Private fields to encapsulate the data
    private String[] presentStudents;
    private int count;

    // Constructor to initialize the fixed-size array
    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.count = 0;
    }

    // Method to mark a student present (ignoring duplicates)
    public void markPresent(String name) {
        // Prevent duplicates by checking if the student is already present
        if (isPresent(name)) {
            return;
        }

        // Check if the array is full before adding
        if (count < presentStudents.length) {
            presentStudents[count] = name;
            count++;
        }
    }

    // Method to return the total count of present students
    public int getPresentCount() {
        return this.count;
    }

    // Method to check if a specific student is marked present
    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}