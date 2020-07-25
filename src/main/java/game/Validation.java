package game;

public class Validation {

    private boolean validLength(String given) {
        return given.length() == 4;
    }

    private boolean validIsNumbersAndIsNotRepeat(String given) {
        String numbers = "0123456789";
        String[] givenArray = given.split("");
        StringBuilder current = new StringBuilder();
        for (String s : givenArray) {
            if (!numbers.contains(s)||current.toString().contains(s)) {
                return false;
            }
            current.append(s);
        }
        return true;
    }


    public boolean isValid(String given) {
        return given != null && validLength(given) && validIsNumbersAndIsNotRepeat(given);
    }
}
