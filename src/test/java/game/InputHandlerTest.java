package game;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {

    @Test
    void should_1234_when_cleanBlank_given_1_2_3_4() {
        //given
        String given = "1 2 3 4";
        InputHandler inputHandler = new InputHandler(new Scanner(System.in));
        //when
        String content = inputHandler.cleanBlank(given);
        //then
        assertEquals("1234",content);
    }
}