package home.ur4eg.dev.dds.IOStreams;

import java.io.*;
import java.util.*;

/**
 * Created by Ur4eG on 11-Mar-16.
 */
public class Prog {

    public static void main(String[] args) {
        //workWithMyBAOS();
        /*MyLinkedListOfByteArraysOutpuStream MLLOBAOS = new MyLinkedListOfByteArraysOutpuStream();
        try {
            MLLOBAOS.write(new byte[]{10,20,30,35,40,35,37});
            byte[] newArray = MLLOBAOS.toByteArray();
            System.out.println(Arrays.toString(newArray));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        File file = new File("D:\\RandomBytes.txt");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        FilenameFilter filter = (path,name)->name.endsWith("pdf");

        /*for(File f: file.listFiles( filter )){
            System.out.print(f.toString() + "; ");
        }*/
        System.out.println();

        //() -> {}

        System.out.println(Arrays.toString(file.listFiles( filter )));

        List<String> list = Arrays.asList("asd", "zxc", "qwe");
        System.out.println(list.toString());
        Collections.sort(list, (a, b)->b.compareTo(a));
        System.out.println(list.toString());

    }

    public static void workWithMyBAOS(){
        File file = new File("d:\\RandomBytes.txt");
        MyLinkedListOfByteArraysOutpuStream MLLOBAOS = null;
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            MLLOBAOS = new MyLinkedListOfByteArraysOutpuStream();
            int b;
            while( (b=fis.read()) != -1 ){
                MLLOBAOS.write(b);
            }
            byte[] newArray = MLLOBAOS.toByteArray();
            System.out.println(Arrays.toString(newArray));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    //NOP
                }
            }
        }
    }
}
