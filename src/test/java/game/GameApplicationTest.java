package game;

import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameApplicationTest {

    @Test
    void should_win_when_start_given_1234() {
        //given
        InputHandler inputHandler = mock(InputHandler.class);
        AnswerGenerator answerGenerator = mock(GuessAnswerGenerator.class);
        given(answerGenerator.generate()).willReturn("1234");
        GameApplication application = new GameApplication(inputHandler, answerGenerator);
        //when
        when(inputHandler.input()).thenReturn("1234");
        when(inputHandler.command()).thenReturn("N");
        application.start();

        //then
        inputHandler.close();


    }

}