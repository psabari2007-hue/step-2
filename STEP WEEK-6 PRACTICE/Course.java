class Course {
    // Fields
    String code;
    String title;
    int credits;
    int labCredits;

    // Constructor setting all four fields directly
    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // Constructor for theory-only courses chaining to the main constructor
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    // Method to calculate total credits
    public int totalCredits() {
        return this.credits + this.labCredits;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a theory-only course object using the 3-argument constructor
        Course theoryCourse = new Course("21CSC201J", "Data Structures", 4);
        
        // Create a course with a lab component using the 4-argument constructor
        Course labCourse = new Course("21CSC205L", "DSA Lab", 3, 1);

        // Print totalCredits() for both courses matching the sample output format
        System.out.println(theoryCourse.code + " total credits: " + theoryCourse.totalCredits());
        System.out.println(labCourse.code + " total credits: " + labCourse.totalCredits());
    }
}