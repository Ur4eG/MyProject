package home.ur4eg.dev.dds.GensAndColls;

import java.util.*;

import static java.util.Arrays.*;

/**
 * Created by Ur4eG on 24-Mar-16.
 */
public class Prog_2 {
    public static void main(String... args) {
        List<Integer> list = new ArrayList<>(asList(1,3,5,2));
        Set<Integer> set = new HashSet<>(asList(5,2,1,4));
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(5,12);
        map.put(10,21);
        map.put(2,2);

        for(Integer i: list){
            System.out.print(i+", ");
        }
        System.out.println();
        //Collections.sort(list);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o1) return 1;
                if(o1<o2) return -1;
                return 0;
            }
        });
        for(Iterator<Integer> iter=list.iterator();iter.hasNext();){
            System.out.print(iter.next()+", ");
        }
        System.out.println();
        for(Map.Entry<Integer,Integer> m: map.entrySet()){
            System.out.println(m.getKey() + " " + m.getValue() + ": " + m);
        }
        for(Integer i: map.keySet()){
            System.out.println(i);
        }

    }
}
