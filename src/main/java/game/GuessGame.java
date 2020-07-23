package game;

public class GuessGame {
    private final String answer;

    public GuessGame(AnswerGenerator answerGenerator) {
        this.answer = answerGenerator.generate();
    }

    public String guess(String numbers) {
        if (answer.equals(numbers)) {
            return "4A0B";
        }
        String temp = this.answer;
        for (String s : numbers.split("")) {
            if (numbers.indexOf(s) == this.answer.indexOf(s)) {
                break;
            }
            temp = temp.replace(s, "");
        }
        if (temp.length() == 0) {
            return "0A4B";
        }
        return "1A3B";
    }
}
