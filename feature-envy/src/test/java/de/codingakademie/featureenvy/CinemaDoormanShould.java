package de.codingakademie.featureenvy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CinemaDoormanShould {
    @Test
    void permit_access_to_old_people() {
        CinemaDoorman doorman = new CinemaDoorman();
        User anton = new User(18);
        Movie movie = new Movie("Horror of the Code");

        assertFalse(doorman.isUserAllowedToVisitTheMovie(anton, movie));
    }

    @Test
    void deny_entry_if_visitor_does_have_insufficient_funds() {
        CinemaDoorman doorman = new CinemaDoorman();
        User anton = new User(18);
        Movie movie = new Movie("Horror of the Code");

        assertFalse(doorman.isUserAllowedToVisitTheMovie(anton, movie));
    }

    @Test
    void permit_entry_if_visitor_does_have_sufficient_funds() {
        CinemaDoorman doorman = new CinemaDoorman();
        User anton = new User(18, new Money("20.00", "EUR"));
        Movie movie = new Movie("Horror of the Code");

        assertTrue(doorman.isUserAllowedToVisitTheMovie(anton, movie));
    }
}
