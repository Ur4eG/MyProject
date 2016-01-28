package home.ur4eg.dev.dds;

import java.util.ArrayList;

/**
 * Created by Ur4eG on 27-Jan-16.
 */
public class HashArray {

    ArrayList [] array;
    int size;

    public HashArray(int size){
        if (size < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+ size);
        array = new ArrayList[size];
        this.size = size;
        for(int i=0; i<size; i++){
            array[i] = new ArrayList();
        }
    }

    public void add(Object value){
        int index = Math.abs(value.hashCode() % 10);
        array[index].add(value);
    }

    public String get(Object value){
        int index = Math.abs(value.hashCode() % 10);
        //array[index].g;
        return null;
    }

    public void print(){
        for(int i=0; i<size; i++){
            System.out.print(i+":");
            for (int j=0; j<array[i].size(); j++) {
                System.out.print("HashArray["+i+"]:"+array[i].get(j) + " ");
            }
            System.out.println();
        }
        //return null;
    }
}
