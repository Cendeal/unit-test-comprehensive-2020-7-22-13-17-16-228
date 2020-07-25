package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenerateAnswerTest {
    @Test
    public void should_return_true_when_generate_given_validation() {
        //given
        Validation validation = new Validation();
        //when
        AnswerGenerator generator = new GuessAnswerGenerator();
        String answer = generator.generate();
        boolean actual = validation.isValid(answer);
        //then
        assertTrue(actual);

    }
}
