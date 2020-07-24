package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationTestUnit {
    @Test
    public void should_return_true_when_is_valid_given_1234() {
        //given
        String given = "1234";
        //when
        Validation validation = new Validation();
        boolean actual = validation.isValid(given);
        //then
        assertTrue(actual);
    }

    @Test
    public void should_return_false_when_is_valid_given_12() {
        //given
        String given = "12";
        //when
        Validation validation = new Validation();
        boolean actual = validation.isValid(given);
        //then
        assertFalse(actual);
    }
}
