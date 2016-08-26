package home.ur4eg.dev.dds.PatternDecorator;

/**
 * Created by Ur4eG on 17-Feb-16.
 */
public class DecoratorMocha extends Decorator {
    //BaseCoffee baseCoffee;

    public DecoratorMocha(BaseCoffee baseCoffee){
        super(baseCoffee);
        //this.baseCoffee = baseCoffee;
        description = "Mocha";
        price = 0.11;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double cost() {
        return price + baseCoffee.cost();
    }
}
