package home.ur4eg.dev.dds.Polymorphysm;

/**
 * Created by Ur4eG on 19-Feb-16.
 */
public class A {
    public int a = 0;
    public static int j = 0;
    public static int k = 0;
    public final int l = 555;
    public A(){
        System.out.println("Constructor of BASE class");
        a = 1;
        j++;
        k += 5;
    }

    public void something(){
        System.out.println("from A");
    }
}
