// Define the Student class with two fields
class Student {
    String name;
    int marks;
}

public class Main {
    public static void main(String[] args) {
        // Create one Student object
        Student student = new Student();

        // Set both fields directly using the sample input
        student.name = "Divya";
        student.marks = 88;

        // Print a single line in the required format
        System.out.println("Name: " + student.name + " | Marks: " + student.marks);
    }
}