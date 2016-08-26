package home.ur4eg.dev.dds.PatternDecorator;

/**
 * Created by Ur4eG on 17-Feb-16.
 */
public class Espresso extends BaseCoffee {

    public Espresso(){
        description = "Espresso";
        price = 2.99;
    }

    @Override
    public double cost() {
        return price;
    }
}
