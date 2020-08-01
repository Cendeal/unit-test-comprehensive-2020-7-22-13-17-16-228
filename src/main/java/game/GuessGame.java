package game;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class GuessGame {
    private final String answer;

    public GuessGame(AnswerGenerator answerGenerator) {
        this.answer = answerGenerator.generate();
    }

    public String guess(String numbers) {
        if (numbers.equals(this.answer)) {
            return "4A0B";
        }
        AtomicInteger countOfB = new AtomicInteger();
        AtomicInteger countOfA = new AtomicInteger();
        String[] answers = this.answer.split("");
        String[] temp = numbers.split("");
        IntStream.range(0, answers.length).forEach(i -> {
            if (temp[i].equals(answers[i])) {
                countOfA.getAndIncrement();
                return;
            }
            if (numbers.contains(answers[i])) {
                countOfB.getAndIncrement();
            }
        });
        return String.format("%sA%sB", countOfA, countOfB);
    }

    public String getAnswer() {
        return this.answer;
    }
}
