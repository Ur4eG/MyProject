package home.ur4eg.dev.dds.IOStreams;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Ur4eG on 31-Mar-16.
 */
public class EntityOutputStream implements EntityOutput {
    private DataOutput out;

    public EntityOutputStream(OutputStream out){
        this.out = new DataOutputStream(out);
    }

    @Override
    public void writePerson(Person p) throws IOException {
        if(p.getName() != null){
            out.writeBoolean(true);
            out.writeInt(p.getName().length());
            //out.writeUTF(p.getName());
            out.writeChars(p.getName());
        }
        else out.writeBoolean(false);
        out.writeInt(p.getAge());
    }

    @Override
    public void writePoint(Point p) throws IOException {
        out.writeInt(p.getX());
        out.writeInt(p.getY());
    }
}
