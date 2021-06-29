package de.codingakademie.featureenvy;

public class User {
    private final Wallet wallet = new Wallet();
    private int age;

    User(int age) {
        this.age = age;
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
