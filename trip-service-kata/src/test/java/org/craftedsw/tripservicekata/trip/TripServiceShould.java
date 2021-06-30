package org.craftedsw.tripservicekata.trip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TripServiceShould {
    private static final User GUEST = null;
    private static final User UNUSED_USER = null;
    private static final User REGISTERED_USER = new User();
    private static final User ANOTHER_USER = new User();
    private static final Trip TO_BRAZIL = new Trip();
    private static final Trip TO_LONDON = new Trip();

    private User loggedInUser;
    private TripService tripService;

    @BeforeEach
    void setUp() {
        tripService = new TestableTripService();
    }

    @Test
    void throw_exception_if_user_is_not_logged_in() {
        loggedInUser = GUEST;

        assertThrows(UserNotLoggedInException.class, () -> tripService.getTripsByUser(UNUSED_USER));
    }

    @Test
    void not_return_any_trips_if_not_friend() {
        loggedInUser = REGISTERED_USER;

        User notFriendToRegisteredUser = UserBuilder.aUser()
                                                    .withFriends(ANOTHER_USER)
                                                    .withTrips(TO_BRAZIL)
                                                    .build();

        List<Trip> tripList = tripService.getTripsByUser(notFriendToRegisteredUser);
        assertEquals(0, tripList.size());
    }

    @Test
    void return_friend_trips_when_user_are_friends() {
        loggedInUser = REGISTERED_USER;
        User friendOfLoggedInUser = UserBuilder.aUser()
                                               .withFriends(loggedInUser)
                                               .withTrips(TO_BRAZIL, TO_LONDON)
                                               .build();

        List<Trip> tripList = tripService.getTripsByUser(friendOfLoggedInUser);

        assertEquals(2, tripList.size());
    }

    public static class UserBuilder {
        private User[] friends = new User[] {};
        private Trip[] trips = new Trip[] {};

        public static UserBuilder aUser() {
            return new UserBuilder();
        }

        public User build() {
            User user = new User();
            for (User friend : friends) {
                user.addFriend(friend);
            }
            for (Trip trip : trips) {
                user.addTrip(trip);
            }
            return user;
        }

        public UserBuilder withTrips(Trip... trips) {
            this.trips = trips;
            return this;
        }

        public UserBuilder withFriends(User... friends) {
            this.friends = friends;
            return this;
        }
    }

    private class TestableTripService extends TripService {
        @Override
        protected User getLoggedInUser() {
            return loggedInUser;
        }

        @Override
        protected List<Trip> tripsBy(User user) {
            return user.trips();
        }
    }
}
