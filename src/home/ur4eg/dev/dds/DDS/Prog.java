package home.ur4eg.dev.dds.DDS;

import java.util.*;

/**
 * Created by Ur4eG on 21-Feb-16.
 */
class GenericClass<T> {
    public <E> void test(Collection<E> collection) {
        for (E e : collection) {
            System.out.println(e);
        }
    }

    public void test(List<Long> list) {
        for (Long l : list) {
            System.out.println(l);
        }
    }
}
public class Prog  {
    public static void main(String[] args) {
        GenericClass<?> genericClass = new GenericClass();
        List<String> list = Arrays.asList("Hello");
        genericClass.test(list);
    }
}
