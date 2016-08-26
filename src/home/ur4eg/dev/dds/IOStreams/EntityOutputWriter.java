package home.ur4eg.dev.dds.IOStreams;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by Ur4eG on 31-Mar-16.
 */
public class EntityOutputWriter implements EntityWriter {
    private Writer out;

    public EntityOutputWriter(Writer out){
        this.out = out;
    }

    @Override
    public void writePerson(Person person) throws IOException {
        out.write("<person>\n");
        out.write("     <Age>"+person.getAge()+"</Age>\n");
        out.write("     <Name>"+person.getName()+"</Name>\n");
        out.write("</person>\n");
        out.flush();
    }

    @Override
    public void writePonit(Point point) {

    }
}
