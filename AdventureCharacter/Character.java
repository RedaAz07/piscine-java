package AdventureCharacter;

public class Character {

    private final int maxHealth;
    private int currentHealth;
    private final String name;

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public String getName() {
        return this.name;
    }

    public Character(String name, int maxHealth) {
        this.maxHealth = maxHealth;
        this.name = name;
        this.currentHealth=maxHealth;
    }

    @Override
    public String toString() {
        if (currentHealth == 0) {
            return String.format("%s :KO", name);
        } else {
            return String.format("%s : %d/%d", name, currentHealth, maxHealth);
        }

    }

    public void takeDamage(int nb) {
        if (currentHealth - nb >= 0) {
            currentHealth -= nb;
        } else {
            currentHealth = 0;
        }

    }

    public void attack(Character chart) {
        chart.takeDamage(9);
    }

    public static void main(String[] args) {
        Character aragorn = new Character("Aragorn", 20);
        Character uruk = new Character("Uruk", 5);
        System.out.println(aragorn.toString());
        System.out.println(uruk.toString());

        aragorn.attack(uruk);

        System.out.println(uruk.toString());

        aragorn.takeDamage(12);

        System.out.println(aragorn.toString());
    }
}
