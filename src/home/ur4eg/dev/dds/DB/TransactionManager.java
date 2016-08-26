package home.ur4eg.dev.dds.DB;

import java.util.concurrent.Callable;

public interface TransactionManager <T> {

    public <T> T runTransaction(Callable<T> job) throws Exception;
}
