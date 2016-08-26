package home.ur4eg.dev.dds.IOStreams;

import java.io.IOException;

/**
 * Created by Ur4eG on 31-Mar-16.
 */
public interface EntityOutput {
    public void writePerson(Person p) throws IOException;
    public void writePoint(Point p) throws IOException;
}
