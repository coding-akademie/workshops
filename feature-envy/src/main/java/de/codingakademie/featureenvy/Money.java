package de.codingakademie.featureenvy;

import java.math.BigDecimal;

public class Money {
    private final BigDecimal value;
    private final String currency;

    public Money(String value, String currency) {
        this.value = new BigDecimal(value);
        this.currency = currency;
    }
}
