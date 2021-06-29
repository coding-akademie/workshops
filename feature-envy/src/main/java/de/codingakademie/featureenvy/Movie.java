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

    public int getEntryFee() {
        return 12;
    }

    public Money getEntryFeeMoney() {
        return new Money("12.00", "EUR");
    }

    public String getName() {
        return name;
    }
}
