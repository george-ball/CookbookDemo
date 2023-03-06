package software.chronicle.services.cookbook.example4a.dto;

import net.openhft.chronicle.wire.SelfDescribingMarshallable;

public class Account extends SelfDescribingMarshallable {

    // the name of the account
    private String name;

    private long accountNumber;

    // the amount in the account
    private double balance;

    public Account ( String name, long accountNumber, double initBalance )  {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = initBalance;
    }

    public long accountNumber() {
        return accountNumber;
    }

    public void add(double value) {
        balance += value;
    }

    public double balance() { return this.balance; }
}
