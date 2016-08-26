package home.ur4eg.dev.dds.PatternStrategy;

/**
 * Created by Ur4eG on 16-Feb-16.
 */
class SubSomething extends Something{

    public SubSomething(){
        // ДЕЛЕГИРОВАНИЕ
        flyBehavior = new CantFly();
        noiseBehavior = new Noiseless();
    }

    public void display(){
        System.out.println("SubSomething is displayed.");
    }

}
