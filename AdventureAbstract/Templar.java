public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int max, int heal, int shield) {
        super(name, max);
        this.healCapacity = heal;
        this.shield = shield;

    }

    public int getHealCapacity() {
        return this.healCapacity;
    }

    @Override
    public void attack(Character chart) {
        heal(this);
        chart.takeDamage(6);
    }

    @Override
    public void takeDamage(int nb) {
        if (this.getCurrentHealth() -(nb - this.shield) >= 0) {
            this.setCurrentHealth(this.getCurrentHealth() - (nb - this.shield));
        } else {
            this.setCurrentHealth(0);
        }

    }

    public void heal(Character cha) {
        if (cha.getCurrentHealth() + this.healCapacity > cha.getMaxHealth()) {
            cha.setCurrentHealth(cha.getMaxHealth());
        } else {

            cha.setCurrentHealth(cha.getCurrentHealth() + this.healCapacity);
        }
    }

    public int getShield() {
        return this.shield;
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() != 0) {
            return String.format("%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d.",
                    this.getName(), this.getCurrentHealth(),
                    this.healCapacity, this.shield);
        } else {
            return String.format("%s has been beaten, even with its %d shield. So bad, it could heal %d HP.",
                    this.getName(),
                    this.shield, this.healCapacity);
        }

    }

    public static void main(String[] args) {
        Templar alistair = new Templar("Alistair", 20, 5, 4);
        Templar roderick = new Templar("Roderick", 10, 3, 2);

        Character.fight(alistair, roderick);

        alistair.heal(alistair);

        System.out.println(Character.printStatus());
    }
}
