package home.ur4eg.dev.dds.IOStreams;

import java.util.ArrayList;
import java.util.List;
/*import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;*/

public class Streams {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Heallo");
        list.add("New");
        list.add("Year");
//
//        Integer reduce = list.stream().map(s -> s.length())
//                .reduce(0, (i1, i2) -> i1 + i2);

        /*String reduce = list.stream()
                .map(s -> String.valueOf(s.charAt(0)))
                .reduce("", (r1, r2) -> r1 + r2);

        List<String> ea = list.stream().filter(s -> s.contains("ea"))
                .collect(Collectors.toList());

        System.out.println(ea);
//                .reduce(0, (i1, i2) -> i1 + i2);


        System.out.println(reduce);*/
        //stream.forEach(s -> System.out.println(s));
    }
}