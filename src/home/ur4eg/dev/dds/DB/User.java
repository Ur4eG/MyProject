package home.ur4eg.dev.dds.DB;

/**
 * Created by Ur4eG on 19-May-16.
 */
public class User {
    public String name;
    public String password;
    public String host;

    @Override
    public String toString(){
        return "name=" + name + " | pass=" + password + " | host=" + host;
    }
}
