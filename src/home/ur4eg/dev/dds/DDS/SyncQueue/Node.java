package home.ur4eg.dev.dds.DDS.SyncQueue;

/**
 * Created by Ur4eG on 30-Jan-16.
 */
public class Node {
    public Object value;
    public Node next;

    public Node(){
        this.value = null;
        this.next = null;
    }

    public Node(Object value){
        this.value = value;
        this.next = null;
    }

    @Override
    public String toString(){
        return value==null ? "" : value.toString();
    }

    public boolean isEmpty(){
        return value == null;
    }
}
