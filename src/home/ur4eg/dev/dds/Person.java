package home.ur4eg.dev.dds;

import java.util.Comparator;
import java.util.Objects;

/**
 * Created by Ur4eG on 21-Mar-16.
 */
public class Person implements Comparable{
    private String name;
    private int age;

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "Name is " + name + "; age is " + age;
    }

    @Override
    public int compareTo(Object o) {
        Objects.requireNonNull(o);
        if(o == null) return 1;
        if(o instanceof Person) {
            Person tmp = (Person) o;
            return (this.age>((Person) o).age) ? 1 :((this.age<((Person) o).age) ? -1 : 0);
        }
        else throw new IllegalArgumentException();
    }
}
