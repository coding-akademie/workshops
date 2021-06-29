package de.codingakademie.featureenvy;

public class CinemaDoorman {
    public void main(String[] args) {
        System.out.println("Welcome to the cinema of Horror movies");

        User anton = new User(18);
        Movie movie = new Movie("Horror of the Code");

        if (anton.getWallet()
                 .getAmount() >= movie.getEntryFee()) {
            if (anton.getAge() >= movie.getAgeRate()) {
                System.out.println(anton.getName() + " visits " + movie.getName());
            }
        }
    }
}
