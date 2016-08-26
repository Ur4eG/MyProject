package home.ur4eg.dev.dds.PatternDecorator;

/**
 * Created by Ur4eG on 17-Feb-16.
 */
public abstract class Decorator extends BaseCoffee {
    BaseCoffee baseCoffee;

    public Decorator(BaseCoffee baseCoffee){
        this.baseCoffee = baseCoffee;
    }

    @Override
    public String toString(){
        return baseCoffee.toString() + "\n" + super.toString() ;
    }

    public abstract String getDescription() ;
}
