package home.ur4eg.dev.dds;

import home.ur4eg.dev.dds.DDS.HashArray;
import home.ur4eg.dev.dds.DDS.Queue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

/**
 * Created by Ur4eG on 27-Jan-16.
 */
public class Prog {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("GO!");
        //playWithQueue();
        //LinkedList
        //System.out.println(System.getProperties());
        /*StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append();*/
        String path =
        //"C:"+System.lineSeparator()+"Users"+System.lineSeparator()+"IBM_ADMIN"+System.lineSeparator()+"Desktop"+System.lineSeparator()+"str.out";
        "C:/Users/IBM_ADMIN/Desktop/str.out";
        File f = new File(path);
        try {
            f.delete();
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintStream original = System.out;
        PrintStream printToFile = new PrintStream(f);
        System.setOut(printToFile);
        System.out.println(path);
        System.out.flush();
        original.println(path);
        original.flush();
        //System.out.println(System.getProperties().toString());
        System.setOut(original);
        printToFile.close();
        //System.out.println(path);

    }

    public static void playWithQueue(){
        Queue queue = new Queue();
        System.out.println(queue.length());
        System.out.println(queue.toString());

        Queue queue1 = new Queue(1);
        System.out.println(queue1.length());
        System.out.println(queue1.toString());

        Queue queue2 = new Queue(2);
        System.out.println(queue2.length());
        System.out.println(queue2.toString());

        Queue queue3 = new Queue(new String("A"));
        System.out.println(queue3.length());
        System.out.println(queue3.toString());
    }

    public static void playWithHashArray(){
        HashArray array = new HashArray(10);

        String a = "abc";
        int b = 10;

        array.add(a);
        array.add(128);
        array.add(1228);
        array.add(new Integer(23232));
        array.add(b);
        array.add(new Queue());

        System.out.println(array);

        array.remove("gfhghfh");
        array.remove(b);

        System.out.println(array);

        System.out.println(Arrays.toString(array.toArray()));
    }
}
