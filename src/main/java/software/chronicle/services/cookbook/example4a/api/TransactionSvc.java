package software.chronicle.services.cookbook.example4a.api;

import software.chronicle.services.cookbook.example4a.dto.Account;
import software.chronicle.services.cookbook.example4a.dto.Transaction;

import java.util.List;

public interface TransactionSvc {
    void transaction(Transaction transaction);
    void accounts(List<Account> accounts);
}
