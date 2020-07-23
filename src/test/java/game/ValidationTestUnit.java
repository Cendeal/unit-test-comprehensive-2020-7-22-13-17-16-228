package game;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidationTestUnit {
    @Test
    public void should_return_false_when_is_valid_input_given_12() {
        //given
        String given = "12";
        //when
        Validation validation = new Validation();
        boolean actual = validation.isValid(given);
        //then
        assertFalse(actual);
    }
}
