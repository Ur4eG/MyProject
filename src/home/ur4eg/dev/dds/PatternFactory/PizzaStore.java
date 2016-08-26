package home.ur4eg.dev.dds.PatternFactory;

/**
 * Created by Ur4eG on 18-Feb-16.
 */
public abstract class PizzaStore {
    Pizza pizza;

    PizzaStore(){};

    public Pizza orderPizza(PizzaType type){
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.convert();
        return pizza;
    }

    protected abstract Pizza createPizza(PizzaType type);
}
