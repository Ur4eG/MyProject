package home.ur4eg.dev.dds.DB;

/**
 * Created by Ur4eG on 19-May-16.
 */
public class DBException extends Exception {

    public DBException(String msg){
        super(msg);
    }

    public DBException(String msg, Throwable cause){
        super(msg, cause);
    }
}
