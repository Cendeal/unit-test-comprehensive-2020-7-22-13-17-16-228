package game;

public class Validation {
    private final int LENGTH = 4;

    public boolean isValid(String given) {
        String[] numbers = given.split("");
        for (String number : numbers) {
            if (given.replaceAll(number, "").length() == LENGTH - 1) {
                continue;
            }
            return false;

        }
        return given.length() == LENGTH;
    }
}
