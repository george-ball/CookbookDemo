package software.chronicle.services.cookbook.example4a.dto;

import net.openhft.chronicle.wire.SelfDescribingMarshallable;

public class Transaction extends SelfDescribingMarshallable {
    private long accountNumber;
    private double amount;

    private Entry entry;

    public long accountNumber() {
        return accountNumber;
    }

    public Transaction accountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public double amount() {
        return amount;
    }

    public Transaction amount(double amount) {
        this.amount = amount;
        return this;
    }

    public Entry entry() {
        return entry;
    }

    public Transaction entry(Entry entry) {
        this.entry = entry;
        return this;
    }
}
