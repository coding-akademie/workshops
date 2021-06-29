package de.codingakademie.featureenvy;

public class Movie {
    private final String name;
    private final int minimumAge;

    Movie(String name) {
        this.name = name;
        this.minimumAge = 18;
    }

    int getAgeRate() {
        return minimumAge;
    }

    public Money entryFee() {
        return new Money("12.00", "EUR");
    }

    public String getName() {
        return name;
    }
}
