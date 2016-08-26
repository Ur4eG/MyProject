package home.ur4eg.dev.dds.PatternDecorator;

/**
 * Created by Ur4eG on 17-Feb-16.
 */
public abstract class AbstractionClass {
    public int i;

    public AbstractionClass(){
        i = 10;
    }

    public void cost(){
        System.out.println("SUPER" + i);
    }

    abstract public void AAA();
}

class abc extends AbstractionClass{
    @Override
    public void cost(){
        //i++;
        System.out.println(i++);
        super.cost();
    }

    @Override
    public void AAA() {

    }
}
