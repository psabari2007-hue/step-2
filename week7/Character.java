public class Character {
    // Private fields to prevent external modification
    private final int maxHealth;
    private int currentHealth;

    // Constructor to set maximum health and initialize current health
    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    // Read-only method to check current health
    public int getHealth() {
        return this.currentHealth;
    }

    // Reduces health and clamps it so it never goes below 0
    public void takeDamage(int amount) {
        this.currentHealth -= amount;
        if (this.currentHealth < 0) {
            this.currentHealth = 0;
        }
    }

    // Increases health and clamps it so it never exceeds maxHealth
    public void heal(int amount) {
        this.currentHealth += amount;
        if (this.currentHealth > this.maxHealth) {
            this.currentHealth = this.maxHealth;
        }
    }
}