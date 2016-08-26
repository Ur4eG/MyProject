package home.ur4eg.dev.dds.PatternFactory.Pizza2;

/**
 * Created by Ur4eG on 18-Feb-16.
 */
public abstract class PizzaFabric implements CookingBehavior {
    @Override
    public Pizza create() {
        return null;
    }

    @Override
    public void cut() {

    }

    @Override
    public void bake() {

    }
}
