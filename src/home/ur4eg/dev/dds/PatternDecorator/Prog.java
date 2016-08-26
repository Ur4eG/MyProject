package home.ur4eg.dev.dds.PatternDecorator;

/**
 * Created by Ur4eG on 17-Feb-16.
 */
public class Prog {
    public static void main(String[] args) {
        BaseCoffee coffee = new Espresso();
        System.out.println(coffee.toString());
        System.out.println("Total: " + coffee.cost());

        BaseCoffee coffee1 = new DecoratorMilk(new Espresso());
        System.out.println(coffee1.toString());
        System.out.println("Total: " + coffee1.cost());

        BaseCoffee coffee2 = new DecoratorMilk(new DecoratorMilk(new DecoratorMocha(new Espresso())));
        System.out.println(coffee2.toString());
        System.out.println("Total: " + coffee2.cost());
    }
}
