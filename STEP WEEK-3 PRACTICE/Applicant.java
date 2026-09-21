public class Applicant {
    // 1. Define a static int totalApplicants field, starting at 0
    public static int totalApplicants = 0;

    // 2. In the constructor, increment totalApplicants by 1 every single time
    public Applicant() {
        totalApplicants++;
    }

    public static void main(String[] args) {
        // 3. Create three Applicant objects
        Applicant app1 = new Applicant();
        Applicant app2 = new Applicant();
        Applicant app3 = new Applicant();

        // 4. Print Applicant.totalApplicants exactly once, accessed through the class name
        System.out.println("Total applicants: " + Applicant.totalApplicants);
    }
}