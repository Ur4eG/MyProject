package home.ur4eg.dev.dds.DDS.SyncQueue;

/**
 * Created by Ur4eG on 26-Jan-16.
 */
public class Queue {
    /**
     *  Очередь (односвязный список). Динамический список объектов Node.
     *  Реализуется путем делегирования с помощью класса Node???
     *  Идея: реализация двухсвязного списка путем делегирования уже с помощью этого(Queue) класса.
     */
    private Node node;
    private int size;

    public Queue(){
        node = null;
        size = 0;
    }

    public Queue(int size){
        if (size < 0)
            throw new IllegalArgumentException("Illegal size: "+ size);
        if (size == 0){
            this.node = null;
            this.size = 0;
        }
        if (size > 0) {
            Node tmp = new Node();
            node = tmp;
            for (int i = 0; i < size - 1; i++) {
                tmp = new Node();
                tmp.next = new Node();
                tmp = tmp.next;
                this.size++;
            }
        }

    }
    /**
     * Проблема:
     * Если принимаемый параметр Object = int, какой конструктор вызовется и почему???
     * Список из size эдементов или список из одного элемента с типом int и значением size ???
     */
    public Queue(Object value){
        node = new Node(value);
        size = 1;
    }

    public int length(){
        return size;
    }

   @Override
    public String toString(){
        if(node==null)
            return "{}";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Node tmp = this.node;
        while(tmp != null && tmp.value != null){
            stringBuilder.append(tmp.value.toString());
            stringBuilder.append(tmp.next==null ? "" :"; ");
            tmp = tmp.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public boolean isEmpty(){
        return node == null;
    }

    public Node lastNode(){
        /*if(isEmpty())
            return null;*/
        Node tmp = node;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        return tmp;
    }

    public void push(Object value){
        if(isEmpty())
            node = new Node(value);
        /*else if(node.isEmpty())
            node.value = value;*/
        else
            lastNode().next = new Node(value);
        size++;
    }

    public void push(Object value, int index){
        if (index < 0)
            throw new IllegalArgumentException("Illegal index: "+ index);
        try{
            Node tmp = node;
            for(int i=0; i<index-2; i++){
                tmp = tmp.next;
            }
            Node newElement = new Node(value);
            newElement.next = tmp.next;
            tmp.next = newElement;
            size++;
        }catch (Exception e){
            System.out.println(e.getMessage()+". Pushing at last position...");
            push(value);
        }

    }

    public void pop(){
        if(!isEmpty()){

        }
        Node tmp = node;
        while(tmp.next.next != null){
            tmp = tmp.next;
        }
        tmp.next = null;
        size--;
    }

    public void pop(int index){
        if (index < 0)
            throw new IllegalArgumentException("Illegal index: "+ index);
        try{
            Node tmp = node;
            for(int i=0; i<index-2; i++){
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;
            size--;
        }catch (Exception e){
            System.out.println(e.getMessage()+". Pop last element...");
            pop();
        }
    }

    public Object pick(){
        Node tmp = node;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        return tmp.value;
    }

    public Object pick(int index){
        if (index < 0)
            throw new IllegalArgumentException("Illegal index: " + index);
        try{
            Node tmp = node;
            for(int i=0; i<index-1; i++){
                tmp = tmp.next;
            }
            return tmp.value;
        }catch(Exception e){
            System.out.println(e.getMessage()+". getting last element...");
            return pick();
        }

    }

    public void replace(Object value){
        lastNode().value = value;
    }

    public void replace(Object value, int index){
        if(index < 0)
            throw new IllegalArgumentException("Illegal index: "+ index);
        try{
            Node tmp = node;
            for(int i=0; i<index-1; i++){
                tmp = tmp.next;
            }
            tmp.next.value = value;
        }catch (Exception e){
            System.out.println(e.getMessage().toString()+". No such element with index="+index);
        }
    }

    public void removeAll(){
        //re-init
        //???
        size = 0;
    }
}
