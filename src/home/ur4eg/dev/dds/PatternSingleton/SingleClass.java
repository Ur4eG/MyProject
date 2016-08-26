package home.ur4eg.dev.dds.PatternSingleton;

/**
 * Created by Ur4eG on 19-Feb-16.
 */
public class SingleClass {
    private static boolean isCreated = false;
    private SingleClass(){
        isCreated = true;
        System.out.println("instance is created");
    }

    public static SingleClass getInstance(){
        if(!isCreated) {
            return new SingleClass();
        }else {
            System.out.println("Just only one instance");
            return null;
        }
    }

    public void proc(){
       System.out.println(isCreated);
    }
}
