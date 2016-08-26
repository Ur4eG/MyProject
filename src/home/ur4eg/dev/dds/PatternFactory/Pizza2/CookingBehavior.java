package home.ur4eg.dev.dds.PatternFactory.Pizza2;

/**
 * Created by Ur4eG on 18-Feb-16.
 */
public interface CookingBehavior {
    Pizza create();
    void cut();
    void bake();
}
