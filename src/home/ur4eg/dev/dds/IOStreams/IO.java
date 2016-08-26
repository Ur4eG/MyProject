package home.ur4eg.dev.dds.IOStreams;

import java.io.*;

/**
 * Created by Ur4eG on 07-Feb-16.
 */
public class IO {
    static String fileFrom = "d:\\Фотографии\\SAM_5260.JPG";
    static String fileTo = "d:\\Фотографии\\SAM_NEW.JPG";

    public static void copyFileStream() {
        for (int i = 1; i < 64 * 1024; i *= 2) {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new FileInputStream(fileFrom);
                out = new FileOutputStream(fileTo);
                long startTime = System.currentTimeMillis();
                copy(in, out, i);
                long endTime = System.currentTimeMillis();
                System.out.println("Elapsed time: " + (endTime - startTime));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException ignore) {
                    }
                }
                if (out != null) {
                    try {
                        out.flush();
                        out.close();
                    } catch (IOException ignore) {
                    }
                }
            }
        }
    }

    public static void copyBufferedStream(){
        for (int i = 1; i < 1024 * 1024; i *= 2) {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new BufferedInputStream(new FileInputStream(fileFrom), i);
                out = new BufferedOutputStream(new FileOutputStream(fileTo), i);
                long startTime = System.currentTimeMillis();
                copy0(in, out, i);
                long endTime = System.currentTimeMillis();
                System.out.println("Elapsed time: " + (endTime - startTime));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException ignore) {
                    }
                }
                if (out != null) {
                    try {
                        out.flush();
                        out.close();
                    } catch (IOException ignore) {
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
            //copyFileStream();
            //copyBufferedStream();
        OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("D:\\ABC.abc")));
        DataOutput a1 = new DataOutputStream(out);
        ObjectOutput a2 = new ObjectOutputStream(out);
        a1.writeInt(123);
        a2.writeInt(456);

        a2.flush();
        a2.close();


        InputStream is = new FileInputStream(new File("D:\\ABC.abc"));
        DataInput b1 = new DataInputStream(is);
        ObjectInput b2 = new ObjectInputStream(is);

        System.out.println(b1.readInt());
        //System.out.println(b2.readInt());

        b2.close();

    }

    private static void copy0(InputStream in, OutputStream out, int buffer) throws IOException {
        int buff;
        int counter = 0;
        while( (buff = in.read()) != -1 ){
            out.write(buff);
            counter++;
        }
        System.out.print("Buffer="+buffer+"; counter="+counter+". ");
    }

    private static void copy(InputStream in, OutputStream out, int bufferSize) throws IOException {
        byte[] buff = new byte[bufferSize];
        int count;
        int counter = 0;
        while( (count = in.read(buff)) != -1 ){
            out.write(buff, 0, count);
            counter++;
        }
        System.out.print("Buffer="+bufferSize+"; counter="+counter+". ");
    }
}
