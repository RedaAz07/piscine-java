public interface Healer {
    public void heal(Character cha) throws DeadCharacterException;

    public int getHealCapacity();
}