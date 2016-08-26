package home.ur4eg.dev.dds.PatternFactory;

/**
 * Created by Ur4eG on 18-Feb-16.
 */
public class Prog {

    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYPizzaStore();
        Pizza pizza2 = pizzaStore.orderPizza(PizzaType.VEGI);
        Pizza pizza1 = new NYPizzaStore().orderPizza(PizzaType.PEPERONNI);

    }
}
