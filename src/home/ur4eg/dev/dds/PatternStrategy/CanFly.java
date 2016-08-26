package home.ur4eg.dev.dds.PatternStrategy;

/**
 * Created by Ur4eG on 16-Feb-16.
 */
class CanFly implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I can fly!");
    }
}
