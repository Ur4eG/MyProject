package home.ur4eg.dev.dds.IOStreams;

import java.io.*;

/**
 * Created by Ur4eG on 31-Mar-16.
 */
public class EntityInputStream implements EntityInput {
    private DataInput in;

    public EntityInputStream(InputStream in){
        this.in = new DataInputStream(in);
    }

    @Override
    public Person readPerson() throws IOException {
        boolean isName = in.readBoolean();
        String name = "";
        if(isName){
            int nameLength = in.readInt();
            for(int i=0; i<nameLength; i++){
                //name = in.readUTF();
                name += in.readChar();
            }
        }
        int age = in.readInt();
        return new Person(name, age);
    }

    @Override
    public Point readPoint() throws IOException {
        int x = in.readInt();
        int y = in.readInt();
        return new Point(x, y);
    }

}
