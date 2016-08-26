package home.ur4eg.dev.dds.MT;

/**
 * Created by Ur4eG on 14-Apr-16.
 */
public class workWithSync {
    public static  void main(String[] args) throws InterruptedException {
        for(int k=0; k<5; k++) {
            final int tmp = k;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    something(tmp);
                }
            }).start();
        }
    }

    public synchronized static void something(int id){
        System.out.println(id + " : here");
        try {
            Thread.sleep(1000);
            workWithSync.class.wait(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
