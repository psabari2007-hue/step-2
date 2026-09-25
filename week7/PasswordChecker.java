public class PasswordChecker {
    // 1. Store the password privately and make it final so it cannot be changed
    private final String password;

    // 2. Constructor to accept and initialize the password once
    public PasswordChecker(String password) {
        this.password = password;
    }

    // 3. Provide a method to return only the strength rating
    public String getStrength() {
        if (this.password == null) {
            return "Weak";
        }

        int length = this.password.length();

        // Evaluate strength based on length thresholds
        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}