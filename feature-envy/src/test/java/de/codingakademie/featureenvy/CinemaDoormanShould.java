package de.codingakademie.featureenvy;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class CinemaDoormanShould {
    @Test
    void permit_access_to_old_people() {
        CinemaDoorman doorman = new CinemaDoorman();
        User anton = new User(18);
        Movie movie = new Movie("Horror of the Code");

        assertFalse(doorman.isUserAllowedToVisitTheMovie(anton, movie));
    }
}
