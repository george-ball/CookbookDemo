package software.chronicle.services.cookbook.example4a;

import software.chronicle.services.cookbook.example4a.api.TransactionSvcOut;
import software.chronicle.services.cookbook.example4a.services.TransactionSvcImpl;
import org.junit.Test;
import software.chronicle.services.util.YamlTester;

public class BalanceTest {
    private static void testMessages(String directory) {
        YamlTester.testMessages(directory, TransactionSvcOut.class, TransactionSvcImpl::new);
    }

    @Test
    public void testBalance() {
        testMessages("test/balance");
    }
}
