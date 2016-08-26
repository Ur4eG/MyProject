package home.ur4eg.dev.dds.DB;

import java.util.List;

/**
 * Created by Ur4eG on 19-May-16.
 */
public interface UserDao {
    public List<User> selectAll() throws DBSystemException ;
    public void insert(User user) throws DBSystemException;
    //public List<User> insert(User user);
}
