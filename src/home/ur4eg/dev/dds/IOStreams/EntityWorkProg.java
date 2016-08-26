package home.ur4eg.dev.dds.IOStreams;

import javax.swing.text.html.parser.Entity;
import java.io.*;

/**
 * Created by Ur4eG on 31-Mar-16.
 */
public class EntityWorkProg {
    public static void main(String[] args) throws IOException {
/*
        EntityOutput entityOutput = null;
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        Person person = new Person("azaza", 18);
        Point point = new Point(12,12);
        entityOutput = new EntityOutputStream(buff);
        EntityInput entityInput = null;
        try {
            entityOutput.writePerson(person);
            System.out.println("success person");
            buff.writeTo(System.out);
            entityOutput.writePoint(point);
            System.out.println("success point");
            buff.writeTo(System.out);

            byte[] bytes = buff.toByteArray();
            for(byte b: bytes){
                System.out.print(b+",");
            }
            System.out.println();
            entityInput = new EntityInputStream(new ByteArrayInputStream(bytes));
            Person person1 = entityInput.readPerson();
            System.out.println(person1);
            Point point1 = entityInput.readPoint();
            System.out.println(point1);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            buff.flush();
            buff.close();
        }

        EntityOutputWriter out = null;
        File file = new File("D:\\aaa");
        out = new EntityOutputWriter(new OutputStreamWriter(System.out));
        out.writePerson(new Person("azaza",19));
*/
        //OutputStream out2 = new FileOutputStream("d:\\");
        String a ;
        Writer w = new StringWriter();
        //OutputStream out = new InputStreamReader()
        w.write("aaa");
        w.flush();
        a = w.toString();
        System.out.println(a);
    }
}
