package de.codingakademie.featureenvy;

public class User {
    private Wallet wallet = new Wallet();
    private int age;

    User(int age) {
        this.age = age;
    }

    User(int age, Money initialWalletFund) {
        this.age = age;
        this.wallet = new Wallet(initialWalletFund);
    }

    public int getAge() {
        return age;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getName() {
        return "anton";
    }

    public boolean canPay(int entryFee) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean canPay(Money price) {
        // TODO Auto-generated method stub
        return false;
    }
}
