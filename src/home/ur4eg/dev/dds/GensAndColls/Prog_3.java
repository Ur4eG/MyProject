package home.ur4eg.dev.dds.GensAndColls;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Ur4eG on 11-Apr-16.
 */
public class Prog_3 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(new Integer(100));
        set.add(new Integer(100));
        System.out.println(set);
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()){
            Integer a = iter.next();
            System.out.println(a + " : " + a.hashCode());
        }
        //System.out.println(sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high"));

    }
}

class A{
    int i = 10;

    @Override
    public String toString(){
        return Integer.toString(i);
    }
}
