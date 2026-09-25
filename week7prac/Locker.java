public class Locker {
    // Requirements: fixed at creation (final) and private combination code with no getter
    private final int lockerNumber;
    private String combinationCode;

    // Constructor to initialize locker number and initial code
    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    /**
     * Changes the combination code only if the provided current code is correct.
     * 
     * @param currentCode The old code entered by the user
     * @param newCode The new code to be set
     * @return true if the code was successfully changed, false otherwise
     */
    public boolean changeCode(String currentCode, String newCode) {
        // Hint 2: Check the old code first before modifying anything
        if (this.combinationCode.equals(currentCode)) {
            this.combinationCode = newCode;
            return true; // Indicates success
        }
        
        return false; // Indicates rejected
    }

    // Getter for locker number (optional, but good practice since it's a fixed property)
    public int getLockerNumber() {
        return lockerNumber;
    }
}