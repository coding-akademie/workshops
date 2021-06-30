package org.craftedsw.tripservicekata.trip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

public class TripServiceShould {
    private static final User GUEST = null;
    private static final User REGISTERED_USER = new User();
    private static final User ANOTHER_USER = new User();
    private static final Trip TO_BRAZIL = new Trip();
    private User loggedInUser;

    @Test
    void throw_exception_if_user_is_not_logged_in() {
        TripService tripService = new TestableTripService();

        loggedInUser = GUEST;

        assertThrows(UserNotLoggedInException.class, () -> tripService.getTripsByUser(null));
    }

    @Test
    void not_return_any_trips_if_not_friend() {
        TripService tripService = new TestableTripService();

        loggedInUser = REGISTERED_USER;
        User notFriendToRegisteredUser = new User();
        notFriendToRegisteredUser.addFriend(ANOTHER_USER);
        notFriendToRegisteredUser.addTrip(TO_BRAZIL);

        List<Trip> tripList = tripService.getTripsByUser(notFriendToRegisteredUser);
        assertEquals(0, tripList.size());
    }

    private class TestableTripService extends TripService {
        @Override
        protected User getLoggedInUser() {
            return loggedInUser;
        }
    }
}
