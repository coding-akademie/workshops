package de.codingakademie.extractclass;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserShould {
    private static final String NAME = "NAME";

    @Test
    void be_constructed_correct() {
        final User user = User.createUser(NAME, null, null, null);

        assertEquals(user.getName(), NAME);
    }
}
