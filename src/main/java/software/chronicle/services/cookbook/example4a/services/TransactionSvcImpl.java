package software.chronicle.services.cookbook.example4a.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.chronicle.services.api.dto.status.Priority;
import software.chronicle.services.cookbook.example4a.api.TransactionSvc;
import software.chronicle.services.cookbook.example4a.api.TransactionSvcOut;
import software.chronicle.services.cookbook.example4a.dto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.openhft.chronicle.core.pool.ClassAliasPool.CLASS_ALIASES;

public class TransactionSvcImpl implements TransactionSvc {

    private static Logger LOG = LoggerFactory.getLogger(TransactionSvcImpl.class);

    static {
        CLASS_ALIASES.addAlias(Account.class);
    }
    private final TransactionSvcOut out;
    private final Map<Long, Account> balanceByAccount = new HashMap<>();
    private final List<Account> allAccounts = new ArrayList<>();

    private OnTransaction onTransaction = new OnTransaction();
    private AccountError accountError = new AccountError();

    public TransactionSvcImpl(TransactionSvcOut out) {
        this.out = out;
    }

    @Override
    public void transaction(Transaction transaction) {
        LOG.info("Applying {} of {} to account {}", transaction.entry(), transaction.amount(), transaction.accountNumber());
        Account account = balanceByAccount.get(transaction.accountNumber());
        if ( account == null ) {
            LOG.error("Unknown account number: {}", transaction.accountNumber());
            accountError.reset();
            accountError.accountNumber(transaction.accountNumber())
                .errorMessage("Unknown Account Number")
                .priority(Priority.MEDIUM);
            out.accountError(accountError);
            return;
        }

        onTransaction.reset();
        transaction.copyTo(onTransaction);

        if ( (transaction.entry() == Entry.DEBIT) && (account.balance() < transaction.amount()) ) {
            LOG.info("Bad transaction: Account {} has insufficient funds for debit: {} [{}]", account.accountNumber(), transaction.amount(), account.balance() );
            out.onTransaction(onTransaction.success(false).reason("Insufficient funds " + account.balance() + " available for " + transaction.amount()));
            return;
        }

        account.add((transaction.entry() == Entry.CREDIT ? transaction.amount() : -transaction.amount()));
        LOG.info("Succeeded: Balance of account {} is now {}", account.accountNumber(), account.balance());
        out.onTransaction(onTransaction.success(true).reason("Balance of account " + account.accountNumber() + " now " + account.balance()));
    }

    @Override
    public void accounts(List<Account> accounts) {
        for (Account account : accounts) {
            LOG.info("Adding account {} with initial balance: {}", account.accountNumber(), account.balance());
            this.balanceByAccount.put(account.accountNumber(), account);
        }
    }
}
