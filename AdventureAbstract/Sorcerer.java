public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int max, int healCapacity) {
        super(name, max);
        this.healCapacity = healCapacity;
    }

    public int getHealCapacity() {
        return this.healCapacity;
    }

    @Override
    public void attack(Character chart) {
        heal(this);
        chart.takeDamage(10);
    }

    @Override
    public void takeDamage(int nb) {
        if (this.getCurrentHealth() - nb >= 0) {
            this.setCurrentHealth(this.getCurrentHealth() - nb);
        } else {
            this.setCurrentHealth(0);
        }

    }

    public void heal(Character cha) {
        if (cha.getCurrentHealth() + healCapacity > cha.getMaxHealth()) {
            cha.setCurrentHealth(cha.getMaxHealth());
        } else {

            cha.setCurrentHealth(cha.getCurrentHealth() + this.healCapacity);
        }
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() != 0) {
            return String.format("%s is a sorcerer with %d HP. It can heal %d HP.", this.getName(),
                    this.getCurrentHealth(),
                    this.healCapacity);
        } else {
            return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", this.getName(),
                    this.healCapacity);
        }

    }



}