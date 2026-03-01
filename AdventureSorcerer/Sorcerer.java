public class Sorcerer extends Character implements Healer {
    private int healCapacity;

    public Sorcerer(String name, int max, int healCapacity) {
        super(name, max);
        this.healCapacity = healCapacity;
    }

    public int getHealCapacity() {
        return this.healCapacity;
    }

    public void heal(Character cha) {
        if (cha.currentHealth + healCapacity > cha.getMaxHealth()) {
            cha.currentHealth = cha.getMaxHealth();
            return;
        }
        cha.currentHealth += this.healCapacity;
    }

    @Override
    public String toString() {
        if (this.currentHealth == 0) {
            return String.format("%s is a sorcerer with %d HP. It can heal %d HP.", this.getName(), this.currentHealth,
                    this.healCapacity);
        } else {
            return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", this.getName(),
                    this.healCapacity);
        }

    }

      public static void main(String[] args) {
        Sorcerer gandalf = new Sorcerer("Gandalf", 20, 5);
        Character frodon = new Character("Frodon", 20);
        Sorcerer saroumane = new Sorcerer("saroumane", 10, 3);

        Character.fight(frodon, saroumane);
        
        gandalf.heal(frodon);

        System.out.println(Character.printStatus());
    }

}