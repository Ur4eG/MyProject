package home.ur4eg.dev.dds.DDS;

import java.util.ArrayList;

/**
 * Created by Ur4eG on 27-Jan-16.
 */
public class HashArray implements Cloneable{

    private ArrayList [] array;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE;

    public HashArray(int size){
        if (size < 0 || size > MAX_ARRAY_SIZE)
            throw new IllegalArgumentException("Illegal Capacity: "+ size);
        array = new ArrayList[size];
        for(int i=0; i<array.length; i++){
            array[i] = new ArrayList();
        }
    }

    public HashArray(){
        array = new ArrayList[0];
        //or for example this array is being created with lenght=1 by default.
        //so in this way we shold do next:
        //HashArray(1);
    }

    public int key(Object value){
        return Math.abs(value.hashCode() % array.length);
    }

    public void add(Object value){
        // need check for overflow
        array[key(value)].add(value);
    }

    public void remove(Object value){
        try{
            array[key(value)].remove(value);
        }catch(Exception e){
            System.out.println("No such element"+e.getMessage());
        }
    }

    private boolean contains(Object value){
        return array[key(value)].contains(value);
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i< array.length; i++){
            if(!array[i].isEmpty()) {
                stringBuilder.append("["+(i+1)+"]:");
                stringBuilder.append(array[i].toString());
                stringBuilder.append('\n');
            }
        }
        return stringBuilder.toString();
    }

    public Object [] toArray(){
        int resultLength = 0;
        for(int i=0; i<array.length;i++){
            resultLength += array[i].size();
        }
        Object [] resultArray = new Object[resultLength];
        int i = 0;
        while (i<resultLength){
            for(int j=0;j<array.length;j++){
                System.arraycopy(array[j].toArray(),0,resultArray,i,array[j].size());
                i += array[j].size();
            }
        }
        return resultArray;
    }

    public HashArray clone(){

        return new HashArray();
    }
}
