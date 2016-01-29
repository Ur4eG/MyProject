package home.ur4eg.dev.dds;

/**
 * Created by Ur4eG on 27-Jan-16.
 */
public class Prog {
    public static void main(String[] args) {

        //System.out.println("A");
        HashArray array = new HashArray(10);
        String a = "abc";
        array.add(a);
        array.add(128);
        array.add(1228);
        array.add(new Integer(23232));
        int i = 10;
        array.add(i);
        //System.out.println(a.hashCode()%10);
        System.out.println(array);
        array.remove("gfhghfh");
        array.remove(i);
        System.out.println(array);
    }
}
