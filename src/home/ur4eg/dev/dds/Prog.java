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
        //System.out.println(a.hashCode()%10);
        array.print();
    }
}
