package de.codingakademie.featureenvy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CinemaDoormanShould {
    @Test
    void permit_access_to_old_people() {
        new CinemaDoorman().main(null);
        assertEquals(0, 1);
    }
}
