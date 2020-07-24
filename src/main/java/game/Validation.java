package game;

public class Validation {

    private boolean validLength(String given) {
        return given.length() == 4;
    }

    private boolean validIsNumbers(String given) {
        String numbers = "0123456789";
        String[] givenArray = given.split("");
        for (String s : givenArray) {
            if (!numbers.contains(s)) {
                return false;
            }
        }
        return true;
    }

    private boolean validNotRepeat(String given) {
        String[] givenArray = given.split("");
        StringBuilder current = new StringBuilder();
        for (String s : givenArray) {
            if (current.toString().contains(s)) {
                return false;
            } else {
                current.append(s);
            }

        }
        return true;
    }


    public boolean isValid(String given) {
        return validLength(given) && validIsNumbers(given) && validNotRepeat(given);
    }
}
