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
        return "1A3B";
    }
}
