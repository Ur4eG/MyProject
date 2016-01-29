package home.ur4eg.dev.dds;

import java.util.ArrayList;

/**
 * Created by Ur4eG on 27-Jan-16.
 */
public class HashArray {

    private ArrayList [] array;
    //private int size;

    public HashArray(int size){
        if (size < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+ size);
        array = new ArrayList[size];
        for(int i=0; i<array.length; i++){
            array[i] = new ArrayList();
        }
    }

    private int getIndex(Object value){
        return Math.abs(value.hashCode() % 10);
    }

    public void add(Object value){
        array[getIndex(value)].add(value);
    }

    public void remove(Object value){
        try{
            array[getIndex(value)].remove(value);
        }catch(Exception e){
            System.out.println("No such element"+e.getMessage());
        }
    }

    private boolean contains(Object value){
        return array[getIndex(value)].contains(value) ? true : false;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i< array.length; i++){
            stringBuilder.append(array[i].toString());
        }
        return stringBuilder.toString();
    }

    /*public void print(){
        for(int i=0; i<size; i++){
            System.out.print(i+":");
            for (int j=0; j<array[i].size(); j++) {
                System.out.print("HashArray["+i+"]:"+array[i].get(j) + " ");
            }
            System.out.println();
        }
        //return null;
    }*/
}
