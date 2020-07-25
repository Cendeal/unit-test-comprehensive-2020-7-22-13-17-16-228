package game;

public class GuessGame {
    private final String answer;

    public GuessGame(AnswerGenerator answerGenerator) {
        this.answer = answerGenerator.generate();
    }

    public String guess(String numbers) {
        if(numbers.equals(this.answer)){
            return "4A0B";
        }
        int countOfB = 0;
        int countOfA = 0;
        String[] answers = this.answer.split("");
        String[] temp = numbers.split("");
        for (int i = 0; i < answers.length; i++) {
            if (temp[i].equals(answers[i])) {
                countOfA++;
                continue;
            }
            if (numbers.contains(answers[i])) {
                countOfB++;
            }
        }
        return String.format("%sA%sB", countOfA, countOfB);
    }

    public String getAnswer() {
        return this.answer;
    }
}
