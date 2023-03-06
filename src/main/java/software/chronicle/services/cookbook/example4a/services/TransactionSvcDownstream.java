package software.chronicle.services.cookbook.example4a.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.chronicle.services.cookbook.example4a.api.TransactionSvcDummy;
import software.chronicle.services.cookbook.example4a.api.TransactionSvcOut;
import software.chronicle.services.cookbook.example4a.dto.AccountError;
import software.chronicle.services.cookbook.example4a.dto.OnTransaction;

public class TransactionSvcDownstream implements TransactionSvcOut {

    private final static Logger LOG = LoggerFactory.getLogger(TransactionSvcDownstream.class);

    private final TransactionSvcDummy out;

    public TransactionSvcDownstream(TransactionSvcDummy out) {
        this.out = out;
    }

    @Override
    public void onTransaction(OnTransaction onTransaction) {
        LOG.info("Account {} has balance {}", onTransaction.accountNumber(), onTransaction.amount());
    }

    @Override
    public void accountError ( AccountError accountError ) {
        LOG.error("Error for account {}: {} [{}]",
            accountError.accountNumber(), accountError.errorMessage(), accountError.priority());
    }

}
