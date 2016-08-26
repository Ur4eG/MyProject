package home.ur4eg.dev.dds.IOStreams;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by Ur4eG on 15-Mar-16.
 */
public class Serialize {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Method[] m = Serialize.class.getDeclaredMethods();
        for(Method a: m){
            System.out.println(a.toString());
        }
    }

    public static  byte[] copyTo(Object o) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(o);
        objectOutputStream.flush();
        objectOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static Object copyFrom(byte[] buff) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buff);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        objectInputStream.close();
        return objectInputStream.readObject();
    }
}


