package software.chronicle.services.cookbook.example4a.api;

import software.chronicle.services.cookbook.example4a.dto.AccountError;
import software.chronicle.services.cookbook.example4a.dto.OnTransaction;

public interface TransactionSvcOut {
    void onTransaction(OnTransaction onTransaction);
    void accountError(AccountError details);
}
