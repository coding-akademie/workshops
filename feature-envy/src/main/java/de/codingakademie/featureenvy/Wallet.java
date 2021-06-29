package de.codingakademie.featureenvy;

public class Wallet {
    private Money value = new Money("0.00", "EUR");

    public Wallet() {
    }

    public Wallet(Money initialWalletFund) {
        value = new Money(initialWalletFund);
    }

    public int getAmount() {
        // TODO Auto-generated method stub
        return 0;
    }

    public boolean contains(Money price) {
        return value.getValue()
                    .compareTo(price.getValue()) >= 0;
    }

}
