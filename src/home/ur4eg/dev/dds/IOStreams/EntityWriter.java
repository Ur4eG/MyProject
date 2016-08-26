package home.ur4eg.dev.dds.IOStreams;

import java.io.IOException;

/**
 * Created by Ur4eG on 31-Mar-16.
 */
public interface EntityWriter {
    public void writePerson(Person person) throws IOException;
    public void writePonit(Point point);
}
