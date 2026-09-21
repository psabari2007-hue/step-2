class Student {
    // Instance fields (unique to each student object)
    String name;
    int attendance;

    // Static fields (shared by all student objects)
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    // Constructor
    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        // Increment the static counter every time a new object is created
        studentCount++;
    }

    // Static method that only accesses static variables
    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class MainStudent {
    public static void main(String[] args) {
        // Create two Student objects
        Student s1 = new Student("Alice", 85);
        Student s2 = new Student("Bob", 90);

        // Call the static method using the class name
        Student.printCollegeInfo();
    }
}