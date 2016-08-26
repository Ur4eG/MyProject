package home.ur4eg.dev.dds.PatternDecorator;

/**
 * Created by Ur4eG on 17-Feb-16.
 */
public class DarkRoast extends BaseCoffee {

    public DarkRoast(){
        description = "Dark Roast";
        price = 1.99;
    }

    @Override
    public double cost() {
        return price;
    }
}
