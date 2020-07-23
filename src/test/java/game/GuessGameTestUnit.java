package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessGameTestUnit {
    @Test
    public void should_return_4A0B_when_play_guess_game_given_1234() {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");

        //given
        String given = "1234";
        //when
        GuessGame gussGame = new GuessGame(answerGenerator);
        String actual = gussGame.guess(given);
        //then
        String expect = "4A0B";
        assertEquals(expect, actual);
    }
}
