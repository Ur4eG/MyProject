package home.ur4eg.dev.dds.PatternFactory;

/**
 * Created by Ur4eG on 18-Feb-16.
 */
public class NYPizzaStore extends PizzaStore {
    //static Pizza pizza;
    @Override
    protected  Pizza createPizza(PizzaType type) {
        if(type.equals(PizzaType.PEPERONNI)){
            System.out.println("creating NY Peperoni pizza!");
            pizza = new PaperoniPizza();
        }else if(type.equals(PizzaType.VEGI)){
            System.out.println("creating NY Vegi pizza!");
            pizza = new VegiPizza();
        }
        return pizza;
    }
}
