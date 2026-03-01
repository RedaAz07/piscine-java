public class Monster extends Character {
    public Monster(String name, int ma) {
        super(name, ma);
    }

    @Override
    public void attack(Character chart) {
        chart.takeDamage(7);
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() > 0) {
            return String.format("%s is a monster with %d HP", this.getName(), this.getCurrentHealth());
        } else {
            return String.format("%s is a monster and is dead", this.getName());

        }

    }

    @Override
    public void takeDamage(int nb) {
        if (this.getCurrentHealth() - (int) (nb * 0.8) >= 0) {
            this.setCurrentHealth(this.getCurrentHealth() - (int) (nb * 0.8));
        } else {
            this.setCurrentHealth(0);
        }

    }


}