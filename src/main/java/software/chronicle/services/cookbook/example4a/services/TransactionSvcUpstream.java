package software.chronicle.services.cookbook.example4a.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.chronicle.services.api.listener.ServiceLifecycleListener;
import software.chronicle.services.cookbook.example4a.api.TransactionSvc;
import software.chronicle.services.cookbook.example4a.dto.Account;
import software.chronicle.services.cookbook.example4a.dto.Entry;
import software.chronicle.services.cookbook.example4a.dto.Transaction;

import java.util.Arrays;
import java.util.List;

public class TransactionSvcUpstream implements ServiceLifecycleListener {
    private static final Logger LOG = LoggerFactory.getLogger(TransactionSvcUpstream.class);
    private TransactionSvc out;
    private final Transaction transaction = new Transaction();

    public TransactionSvcUpstream(TransactionSvc out) {
        this.out = out;
    }

    @Override
    public void start() {
        List<Account> initAccounts = Arrays.asList(
            new Account("currentAccount", 34343434, 100.0 ),
            new Account("savingsAccount", 45454545, 200.0 )
        );
        out.accounts(initAccounts);

        out.transaction(transaction.accountNumber(34343434).entry(Entry.DEBIT).amount(100));
        out.transaction(transaction.accountNumber(34343434).entry(Entry.DEBIT).amount(50));
        out.transaction(transaction.accountNumber(45454545).entry(Entry.CREDIT).amount(10));
    }


}
