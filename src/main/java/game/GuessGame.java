package game;

public class GuessGame {
    private final String answer;

    public GuessGame(AnswerGenerator answerGenerator) {
        this.answer = answerGenerator.generate();
    }

    public String guess(String numbers) {
        int countOfB = 0;
        int countOfA = 0;
        String[] answers = this.answer.split("");
        for (int i = 0; i < answers.length; i++) {
            if (numbers.indexOf(answers[i]) == i) {
                countOfA++;
                continue;
            }
            if (numbers.contains(answers[i])) {
                countOfB++;
            }
        }
        return String.format("%sA%sB", countOfA, countOfB);
    }
}
