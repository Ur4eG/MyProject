package home.ur4eg.dev.dds.Polymorphysm;

/**
 * Created by Ur4eG on 19-Feb-16.
 */
public class Prog {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("a.j="+a.j);
        System.out.println("a.k="+a.k);
        A b = new B();
        System.out.println(b.a);
        //System.out.println(b.getSuper_a());
        System.out.println("b.j="+b.j);
        System.out.println("b.k="+b.k);
        System.out.println("a.j="+a.j);
        System.out.println("a.k="+a.k);
        a.k = 50;
        System.out.println("a.k="+a.k+"; b.k="+b.k);
        b.k = 100;
        System.out.println("a.k="+a.k+"; b.k="+b.k);
        a.j = 200;
        System.out.println("a.j="+a.j+"; b.j="+b.j);
        System.out.println(a.l);
        System.out.println(b.l);
        a.something();
        b.something();
    }
}
