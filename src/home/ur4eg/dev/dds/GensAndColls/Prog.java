package home.ur4eg.dev.dds.GensAndColls;

import home.ur4eg.dev.dds.Person;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

public class Prog {
    public static void main(String[] args) {
        /*int [] arr = {1,3,2};
        for(int i: arr){
            System.out.println(i);
        }
        Decorator.sort(arr);
        for(int i: arr){
            System.out.println(i);
        }*/
        /*Person newPerson = new Person("CCC",10);
        PersonArray arr = new PersonArray();
        for(Person p: arr){
            System.out.println(p);
            System.out.println(p.compareTo(newPerson));
        }*/

       /* Collection<Integer> list = new TreeSet<>();
        list.add(123);
        list.add(423);
        list.add(223);
        System.out.println(list);*/

        List<? extends Number> arr = new ArrayList<Integer>();

       int i = 0;
        System.out.println((i+++ ++i));

    }
}

class PersonArray implements Iterable<Person>{
    public Person [] persArr;

    public PersonArray(){
        persArr = new Person[] {new Person("AAA",10),
                                new Person("ABC",15),
                                new Person("ABB",12),
                                new Person("AAC",19) };
    }


    @Override
    public Iterator<Person> iterator() {
        return new PersonArrayIterator(persArr);
    }

    public void aaa(Person p){
        System.out.println("this is Generic method");
    }

    public void aaa(Object o){
        System.out.println("this is NOT Generic method");
    }
}

class PersonArrayIterator implements Iterator<Person>{
    private Person[] arr;
    private int index = 0;

    public PersonArrayIterator(Person[] arr){
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        return index < arr.length;
    }

    @Override
    public Person next() {
        return arr[index++];
    }
}

class Decorator{
    public static void sort(int[] arr){
        System.out.println("Sorting...");
        Arrays.sort(arr);
    }
}
