package game;

import java.util.Random;

public class GuessAnswerGenerator implements AnswerGenerator {

    @Override
    public String generate() {
        StringBuilder builder = new StringBuilder("0123456789");
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<4;i++){
            int random = new Random().nextInt(builder.length());
            answer.append(builder.charAt(random));
            builder.deleteCharAt(random);
        }
        return answer.toString();
    }
}
