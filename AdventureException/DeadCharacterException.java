public class DeadCharacterException extends Exception {

    private Character character;

    public DeadCharacterException(Character character) {
        this.character = character;
    }

    @Override
    public String getMessage() {

        String type = "";

        if (character instanceof Sorcerer) {
            type = "sorcerer";
        } else if (character instanceof Templar) {
            type = "templar";
        } else if (character instanceof Monster) {
            type = "monster";
        }

        return "The " + type + " " + character.getName() + " is dead.";
    }
}