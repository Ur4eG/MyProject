package home.ur4eg.dev.dds.IOStreams;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Ur4eG on 28-Mar-16.
 */
public interface EntityInput {
    public Person readPerson() throws IOException;
    public Point readPoint() throws IOException;
}
