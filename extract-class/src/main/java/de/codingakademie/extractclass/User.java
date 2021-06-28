package de.codingakademie.extractclass;

public class User {
    private String name;
    private long personalCryptoKey;
    private String mobil;
    private String fax;
    private String address;

    public User(String name, long personalCryptoKey, String mobil, String fax, String address) {
        this.name = name;
        this.personalCryptoKey = personalCryptoKey;
        this.mobil = mobil;
        this.fax = fax;
        this.address = address;
    }

    public static User createUser(String name, String mobil, String fax, String address) {
        System.out.println("create user " + name);

        int seed = 12345;
        long seedFromCryptoSource = new QuantumCryptoSource().seed();
        long personalCryptoKey = seed + seedFromCryptoSource * 9 + seedFromCryptoSource ^ seed;
        personalCryptoKey = -seed + seedFromCryptoSource;

        name += seed;

        return new User(name, personalCryptoKey, mobil, fax, address);
    }

    public String getName() {
        return name;
    }
}
