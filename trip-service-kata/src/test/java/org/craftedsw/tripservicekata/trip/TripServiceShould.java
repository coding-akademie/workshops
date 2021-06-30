package org.craftedsw.tripservicekata.trip;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

public class TripServiceShould {
    @Test
    void throw_exception_if_user_is_not_logged_in() {
        TripService tripService = new TestableTripService();

        assertThrows(UserNotLoggedInException.class, () -> tripService.getTripsByUser(null));
    }

    private class TestableTripService extends TripService {
        @Override
        protected User getLoggedInUser() {
            return null;
        }
    }
}
