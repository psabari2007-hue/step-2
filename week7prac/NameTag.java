public class NameTag {
    // Final fields ensure the class remains immutable
    private final String firstName;
    private final String lastNameInitial;

    /**
     * Constructor that takes a full name and splits it.
     * Assumes exactly one first name and one last name separated by a single space.
     */
    public NameTag(String fullName) {
        // Split the full name by the space character
        String[] nameParts = fullName.split(" ");
        
        // Store the parts into final fields immediately
        this.firstName = nameParts[0];
        
        // Get the first character of the last name and add a period
        this.lastNameInitial = nameParts[1].substring(0, 1) + ".";
    }

    /**
     * Combines the stored parts to return the nickname.
     */
    public String getNickname() {
        return this.firstName + " " + this.lastNameInitial;
    }
}