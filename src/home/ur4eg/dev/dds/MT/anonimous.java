package home.ur4eg.dev.dds.MT;

/**
 * Created by Ur4eG on 13-Apr-16.
 */
public class anonimous {
    public static void main(String[] args) {
        anonimous a = new anonimous();
        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };
        System.out.println(a.getClass().getName());
        System.out.println(r.getClass().getName());
    }


}
