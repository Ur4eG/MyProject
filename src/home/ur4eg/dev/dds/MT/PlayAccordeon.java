package home.ur4eg.dev.dds.MT;

/**
 * Created by Ur4eG on 14-Apr-16.
 */
public class PlayAccordeon {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Let's create Thread!");
        Thread thread = new Thread(new subWorker());
        thread.start();
        System.out.println("connect to Thread");
        thread.join();
        System.out.println("Thread is dead...");
    }
}

class subWorker implements Runnable{
    @Override
    public void run() {
        for(int k=0; k<5;k++) {
            for (int i = 0; i < 5; i++) {
                Thread t1 = new Thread(new newRunnable("A   .", 100));
                t1.start();
                Thread t2 = new Thread(new newRunnable(".   B", 90));
                t2.start();
                try {
                    t1.join();
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 10; i++) {
                Thread t3 = new Thread(new newRunnable("  C  ", 100));
                t3.start();
                try {
                    t3.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class newRunnable implements Runnable{
    private String str;
    private long milli;

    public newRunnable(String str, long milli){
        this.str = str;
        this.milli = milli;
    }

    @Override
    public void run() {
        System.out.println(str);
        try {
            Thread.sleep(milli);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}