package game;

import java.util.Random;

public class GuessAnswerGenerator implements AnswerGenerator {

    @Override
    public String generate() {
        StringBuilder builder = new StringBuilder("0123456789");
        StringBuilder answer = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int number = random.nextInt(builder.length());
            answer.append(builder.charAt(number));
            builder.deleteCharAt(number);
        }
        return answer.toString();
    }
}
