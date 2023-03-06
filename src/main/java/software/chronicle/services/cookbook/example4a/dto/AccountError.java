package software.chronicle.services.cookbook.example4a.dto;

import net.openhft.chronicle.wire.SelfDescribingMarshallable;
import software.chronicle.services.api.dto.status.Priority;

public class AccountError extends SelfDescribingMarshallable {
    private long accountNumber;
    private String errorMessage;
    private Priority priority;

    public long accountNumber() {
        return this.accountNumber;
    }
    public AccountError accountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public String errorMessage() { return this.errorMessage;}
    public AccountError errorMessage ( String errorMessage ) {
        this.errorMessage = errorMessage;
        return this;
    }

    public Priority priority() { return this.priority; }
    public AccountError priority( Priority priority ) {
        this.priority = priority;
        return this;
    }
}
