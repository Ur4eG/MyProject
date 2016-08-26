package home.ur4eg.dev.dds.DDS.GenericQueue;

import java.util.Iterator;

/**
 * Created by Ur4eG on 01-Feb-16.
 */
public class GenericQueue<SomeType> implements Iterable{
    private GenericNode<SomeType> node;
    private int size;

    public GenericQueue(SomeType val) {
        node = new GenericNode(val);
        size++;
    }

    public GenericQueue(){
        node = new GenericNode<>();
        size++;
    }

    public GenericQueue(int size){
        if(size < 0)
            throw new IllegalArgumentException("Illegal size "+ size);
        for(int i=0; i<size; i++){
            GenericNode<SomeType> tmp = new GenericNode<>();
            node.next = tmp;
            size++;
        }
    }

    public int length(){
        return size;
    }

    @Override
    public String toString(){
        GenericNode tmp = node;
        StringBuilder stringBuilder = new StringBuilder();
        while(tmp != null){
            stringBuilder.append(tmp.value.toString());
            stringBuilder.append("; ");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
