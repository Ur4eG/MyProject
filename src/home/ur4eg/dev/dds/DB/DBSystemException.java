package home.ur4eg.dev.dds.DB;

/**
 * Created by Ur4eG on 19-May-16.
 */
public class DBSystemException extends DBException {

    public DBSystemException(String msg) {
        super(msg);
    }

    public DBSystemException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
