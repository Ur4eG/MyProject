package home.ur4eg.dev.dds.PatternStrategy;

public class Prog {
    public static void main(String[] args) {
        Something a = new SubSomething();
        a.performFly();
        a.performNoise();
        //a.setFlyBehavior(CanFly);
        /*new Something(new LoFly());
        new Something(new FastFly());*/

        Something b = new SubSomethingElse();
        b.performFly();
        b.performNoise();
        b.setFlyBehavior(new CantFly());
        b.performFly();
    }
}
