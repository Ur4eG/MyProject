package home.ur4eg.dev.dds.PatternStrategy;

/**
 * Created by Ur4eG on 16-Feb-16.
 */
class SubSomethingElse extends  Something{

    public SubSomethingElse(){
        flyBehavior = new CanFly();
        noiseBehavior = new Noiseless();
    }

    @Override
    public void display() {
    }
}
