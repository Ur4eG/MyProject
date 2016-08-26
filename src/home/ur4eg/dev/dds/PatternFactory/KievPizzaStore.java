package home.ur4eg.dev.dds.PatternFactory;

/**
 * Created by Ur4eG on 18-Feb-16.
 */
public class KievPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(PizzaType type) {
        if(type.equals(PizzaType.PEPERONNI)){
            System.out.println("creating Kiev Peperoni pizza!");
            pizza = new PaperoniPizza();
        }else if(type.equals(PizzaType.VEGI)){
            System.out.println("creating Kiev Vegi pizza!");
            pizza = new VegiPizza();
        }
        return pizza;
    }
}
