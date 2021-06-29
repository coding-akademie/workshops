package de.codingakademie.featureenvy;

public class CinemaDoorman {
    public void main(String[] args) {
        System.out.println("Welcome to the cinema of Horror movies");

        User anton = new User(18);
        Movie movie = new Movie("Horror of the Code");

        boolean userIsAllowToVisitTheMovie = isUserAllowedToVisitTheMovie(anton, movie);

        if (userIsAllowToVisitTheMovie) {
            System.out.println(anton.getName() + " visits " + movie.getName());
        }
    }

    boolean isUserAllowedToVisitTheMovie(User anton, Movie movie) {
        if (anton.canPay(movie.entryFee())) {
            if (anton.getAge() >= movie.getAgeRate()) {
                return true;
            }
        }
        return false;
    }
}
