package game;

public class Validation {
    private final int LENGTH = 4;
    public boolean isValid(String given) {
        return given.length() == LENGTH;
    }
}
