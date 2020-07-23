package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessGameTestUnit {
    @Test
    public void should_return_4A0B_when_play_guess_game_given_1234() {
        //given
        String given = "1234";
        //when
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
        GuessGame gussGame = new GuessGame(answerGenerator);
        String actual = gussGame.guess(given);
        //then
        String expect = "4A0B";
        assertEquals(expect, actual);
    }

    @Test
    public void should_return_1A3B_when_play_guess_game_given_1342() {
        //given
        String given = "1342";
        //when
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
        GuessGame gussGame = new GuessGame(answerGenerator);
        String actual = gussGame.guess(given);
        //then
        String expect = "1A3B";
        assertEquals(expect, actual);
    }

    @Test
    public void should_return_0A4B_when_play_guess_game_given_3421() {
        //given
        String given = "3421";
        //when
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
        GuessGame gussGame = new GuessGame(answerGenerator);
        String actual = gussGame.guess(given);
        //then
        String expect = "0A4B";
        assertEquals(expect, actual);
    }
}
