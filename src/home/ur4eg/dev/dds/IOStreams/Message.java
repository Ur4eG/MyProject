package home.ur4eg.dev.dds.IOStreams;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message implements Serializable {
    private String name;
    private Date date;
    private String message;
    static final long serialVersionUID = 1027553947283749L;

    public Message(String name, String message, Date date){
        this.name = name;
        this.message = message;
        this.date = date;
    }

    public Message(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("starting read from file");
        readExternal(in);
    }

    /*private void writeObject(ObjectOutputStream oos) throws IOException{
        throw new NotSerializableException("Not today!");
    }

    private void readObject(ObjectInputStream ois) throws IOException{
        throw new NotSerializableException("Cant read. Not serializable object!");
    }*/

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(name.length());
        out.writeChars(name);
        out.writeInt(message.length());
        out.writeChars(message);
        out.writeInt(date.toString().length());
        out.writeChars(date.toString());
        out.writeLong(serialVersionUID);
        System.out.println("data saved.");
        //out.writeInt(date.);
        out.flush();
        out.close();
    }
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException{
        //long timeStart = System.currentTimeMillis();
        int marker=in.readInt();
        String tmp = "";
        for(int i=0; i<marker; i++){
            tmp += in.readChar();
        }
        this.name = tmp;
        //System.out.println(tmp);
        marker=in.readInt();
        tmp = "";
        for(int i=0; i<marker; i++){
            tmp += in.readChar();
        }
        this.message = tmp;
        //System.out.println(tmp);
        marker=in.readInt();
        tmp = "";
        for(int i=0; i<marker; i++){
            tmp += in.readChar();
        }
        //System.out.println(tmp);
        //this.date = tmp.;
        //long timeEnd = System.currentTimeMillis();
        //System.out.println(timeEnd - timeStart);
        if(this.serialVersionUID != in.readLong()){
            System.out.println("UID is not correct!");
        }
    }

    @Override
    public String toString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return name + "; " + simpleDateFormat.format(date) + "; " + message;
    }
}

