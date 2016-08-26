package home.ur4eg.dev.dds.PatternDecorator;

/**
 * Created by Ur4eG on 17-Feb-16.
 */
public abstract class BaseCoffee {
    String description;
    double price;

    public String getDescription(){
        return description;
    }

    public double getPrice(){
        return price;
    }

    public String toString(){
        return getDescription() + " " + getPrice();
    }

    public abstract double cost();
}
