package home.ur4eg.dev.dds.PatternStrategy;

/**
 * Created by Ur4eG on 16-Feb-16.
 */
class CantFly implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I can't fly... ");
    }
}
