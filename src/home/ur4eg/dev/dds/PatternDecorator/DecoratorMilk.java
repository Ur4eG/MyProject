package home.ur4eg.dev.dds.PatternDecorator;

/**
 * Created by Ur4eG on 17-Feb-16.
 */
public class DecoratorMilk extends Decorator {
    //BaseCoffee baseCoffee;

    public DecoratorMilk(BaseCoffee baseCoffee){
        super(baseCoffee);
        //this.baseCoffee = baseCoffee;
        description = "Milk";
        price = 0.20;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double cost() {
        return price + baseCoffee.cost();
    }

    /*@Override
    public String toString(){
        return baseCoffee.toString() + "\n" + super.toString() ;
    }*/
}
