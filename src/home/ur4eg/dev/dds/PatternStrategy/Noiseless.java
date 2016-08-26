package home.ur4eg.dev.dds.PatternStrategy;

/**
 * Created by Ur4eG on 16-Feb-16.
 */
class Noiseless implements  NoiseBehavior{
    @Override
    public void noise() {
        System.out.println("I'm noiseless...");
    }
}
