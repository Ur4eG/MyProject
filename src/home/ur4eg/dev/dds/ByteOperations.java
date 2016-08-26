package home.ur4eg.dev.dds;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ur4eG on 09-Mar-16.
 */
public class ByteOperations {
    static File file = new File("d:\\RandomBytes.txt");
    //static File fileOut = new File("d:\\My_Optimized_BAOS.txt");

    public static void main(String[] args) {

        //writeTo();
        //readFrom();
        byte i = 100;
        System.out.println(i >> 1);
    }

    static public void readFrom(){
        FileInputStream fis = null;
        ByteArrayOutputStream BAOS = null;
        //byte [] byteArray = new byte[4];
        try {
            fis = new FileInputStream(file);
            BAOS = new ByteArrayOutputStream(1);
            int i;
            long startT, endT;
            //startT = System.currentTimeMillis();
            while((i=fis.read()) != -1) {
                BAOS.write(i);
                //Thread.sleep(5);
                //endT = System.currentTimeMillis();
                //System.out.println(i + "\t" + (endT-startT) + " ms");
                //System.out.print(i);
                //System.out.println(i);
            }
            byte finalArray [] = BAOS.toByteArray();
            System.out.println(Arrays.toString(finalArray));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    //NOP
                }
            }
        }

    }

    static public void writeTo(){
        OutputStream out = null;
        DataOutputStream dos = null;
        //Random random = new Random();
        try {
            out = new FileOutputStream(file);
            dos = new DataOutputStream(out);
            int A;
            for(int i=0; i<10; i++) {
                //A = random.nextInt(256);
                A = 48+i;
                dos.writeChar(A);
                System.out.println(A + " = " + (char)A);
            }
            dos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(dos != null){
                try {
                    dos.close();
                } catch (IOException e) {
                    //NOP
                }
            }
        }
    }
}


