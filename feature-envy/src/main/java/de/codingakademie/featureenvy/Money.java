package de.codingakademie.featureenvy;

import java.math.BigDecimal;

public class Money {
    private final BigDecimal value;
    private final String currency;

    public Money(String value, String currency) {
        this.value = new BigDecimal(value);
        this.currency = currency;
    }

    public Money(Money money) {
        // for immutable classes: rule construct your own copy
        // here: BigDecimal and String is immutable and the assignment operator creates an independent copy
        this.value = money.value;
        this.currency = money.currency;
    }

    public BigDecimal getValue() {
        // for immutable classes: rule construct a copy of a value before returning
        // here: since BigDecial is already immutable, returning plainly is okay.
        return value;
    }
}
