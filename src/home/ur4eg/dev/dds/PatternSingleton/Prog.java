package home.ur4eg.dev.dds.PatternSingleton;

/**
 * Created by Ur4eG on 19-Feb-16.
 */
public class Prog {
    public static void main(String[] args) {
        SingleClass a = SingleClass.getInstance();
        a.proc();
        SingleClass b = SingleClass.getInstance();
        System.out.println(b);
            b.proc();
    }
}
