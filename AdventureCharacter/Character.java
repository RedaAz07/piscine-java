package AdventureCharacter;

public class Character {

    private final int maxHealth;
    private int currentHealth;
    private final String name;

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public String getName() {
        return name;
    }

    public Character(String name, int maxHealth) {
        this.maxHealth = maxHealth;
        this.name = name;
        this.currentHealth=maxHealth;
    }

    @Override
    public String toString() {
        if (currentHealth == 0) {
            return String.format("%s :KO", this.name);
        } else {
            return String.format("%s : %d/%d", this.name, this.currentHealth, this.maxHealth);
        }

    }

    public void takeDamage(int nb) {
        if (this.currentHealth - nb >= 0) {
            this.currentHealth -= nb;
        } else {
            this.currentHealth = 0;
        }

    }

    public void attack(Character chart) {
        chart.takeDamage(9);
    }

}
