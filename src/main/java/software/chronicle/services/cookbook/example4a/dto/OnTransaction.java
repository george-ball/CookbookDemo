package software.chronicle.services.cookbook.example4a.dto;

public class OnTransaction extends Transaction {

    private boolean success;
    private String reason;

    public boolean success() { return this.success; }

    public OnTransaction success( boolean success ) {
        this.success = success;
        return this;
    }

    public String reason () { return this.reason; }

    public OnTransaction reason( String reason ) {
        this.reason = reason;
        return this;
    }
}
