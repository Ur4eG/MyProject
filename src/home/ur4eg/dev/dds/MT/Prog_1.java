package home.ur4eg.dev.dds.MT;

/**
 * Created by Ur4eG on 13-Apr-16.
 */
public class Prog_1 {
    public static  boolean in0 = false;
    public static volatile boolean in1 = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    in0 = true;
                    if (!in1){
                        System.out.println(0);
                        System.out.println(0);
                    }
                    in0 = false;
                }
            }
        }) ;
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    in1 = true;
                    if(!in0){
                        System.out.println(1);
                        System.out.println(1);
                    }
                    in1 = false;
                }
            }
        });
        t2.start();
    }
}
