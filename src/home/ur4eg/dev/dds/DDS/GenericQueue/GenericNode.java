package home.ur4eg.dev.dds.DDS.GenericQueue;

/**
 * Created by Ur4eG on 01-Feb-16.
 */
public class GenericNode<SomeType> {
    public SomeType value;
    public GenericNode<SomeType> next;

    public GenericNode(SomeType obj){
        value = obj;
        next = null;
    }

    public GenericNode(){
        value = null;
        next = null;
    }

    @Override
    public String toString(){
        return value.toString();
    }
}
