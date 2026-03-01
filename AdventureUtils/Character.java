
import java.util.ArrayList;
import java.util.List;

public class Character {

    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private static List<Character> allCharacters = new ArrayList<>() ;

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
        this.currentHealth = maxHealth;
        allCharacters.add(this);
    }

    @Override
    public String toString() {
        if (this.currentHealth == 0) {
            return String.format("%s : KO", this.name);
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

    public static String printStatus() {
        if (allCharacters.size() == 0) {
            return String.format(
                    "------------------------------------------\nNobody's fighting right now !\n------------------------------------------\n");

        } else {
            StringBuilder str = new StringBuilder();
            str.append("------------------------------------------\nCharacters currently fighting :\n");
            for (Character elem : allCharacters) {
                str.append(" - " + elem.toString() + "\n");
            }
            str.append("------------------------------------------\n");
            return str.toString();
        }
    }

    public static Character fight(Object char1, Object char2) {
        Character a = (Character) char1;
        Character b = (Character) char2;

        while (true) {
            a.attack(b);
            if (b.getCurrentHealth() == 0) {
                return a;
            } 
            b.attack(a);
            if (a.getCurrentHealth() == 0) {
                return b;
            } 
        }
    }

   public static void main(String[] args) {
        System.out.print(Character.printStatus());

        Character aragorn = new Character("Aragorn", 20);
        Character uruk = new Character("Uruk", 15);

        System.out.print(Character.printStatus());

        Character winner = Character.fight(aragorn, uruk);

        System.out.println(winner.toString());
        System.out.print(Character.printStatus());
    }

}
