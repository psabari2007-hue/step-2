public class Main {
    public static void main(String[] args) {
        // Create one Course object through the constructor
        Course course = new Course("21CSC201J", "Data Structures");
        
        // Print its two fields on one line
        System.out.println(course.code + " - " + course.title);
    }
}

class Course {
    // Define fields
    String code;
    String title;

    // Basic constructor
    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }
}