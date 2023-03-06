package software.chronicle.services.cookbook.example4a;

import net.openhft.chronicle.core.io.IOTools;
import software.chronicle.services.runner.ThreadRunner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        IOTools.deleteDirWithFiles("target/data");
        ThreadRunner.runAll("services.yaml");
        Thread.sleep(10_000);
    }

}
