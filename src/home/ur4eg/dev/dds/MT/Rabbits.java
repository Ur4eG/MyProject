package home.ur4eg.dev.dds.MT;

/**
 * Created by Ur4eG on 14-Apr-16.
 */
public class Rabbits {
    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i < 2; i++){
            Runnable r = new MyRunnable(spaces(i)+"[M]",i);
            new Thread(r).start();
            Thread.sleep(1000);
        }
    }

    public static String spaces(int count){
        StringBuilder result = new StringBuilder("");
        for(int i=0; i< count; i++){
            result.append(" ");
        }
        return result.toString();
    }
}

class MyRunnable implements Runnable{
    private String msg;
    private long millis;

    public MyRunnable(String msg, long millis) {
        this.msg = msg;
        this.millis = millis;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        threadName = threadName.substring(threadName.indexOf('-')+1);
        msg = msg + '['+threadName+']';
        for(int i=0; i<1; i++){
            System.out.println(msg + millis);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Runnable r = new MyRunnable(msg,millis+i);
            new Thread(r).start();
        }
        System.out.println(Thread.currentThread()+"is over");
    }
}