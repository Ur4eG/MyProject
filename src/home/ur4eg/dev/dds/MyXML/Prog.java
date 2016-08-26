package home.ur4eg.dev.dds.MyXML;

import java.io.*;
import java.util.*;

public class Prog {
    static String file = "d://aaa";
    public static void main(String[] args) throws Exception {

        Reader in = new FileReader(file);
        //InputStream in = new FileInputStream(file);
        new XmlStruct(in).readXml();
        //new XmlStruct().readOpenTag(in);

/*
        StringBuilder sb;

        List<String> list = new ArrayList<>();
        Map<String, Integer> words = new TreeMap<>();
        Map<Character,Integer> chars = new HashMap<>();
        int c;
        while((c=in.read())!=-1){
            if(chars.containsKey((char)c))
                chars.replace((char)c,chars.get((char)c)+1);
            else
                chars.put((char)c,1);
            if(c!=' ' && c!='\n' && c!='<' && c!='>' && c!='/'){
                sb = new StringBuilder();
                while(c != ' ' && c != -1 && c!='\n' && c!='<' && c!='>' && c!='/'){
                    sb.append((char)c);
                    c = in.read();
                    if(chars.containsKey((char)c))
                        chars.replace((char)c,chars.get((char)c)+1);
                    else
                        chars.put((char)c,1);
                }
                if(words.containsKey(sb.toString()))
                    words.replace(sb.toString(),words.get(sb.toString())+1);
                else
                    words.put(sb.toString(),1);
                list.add(sb.toString());
            }
        }
        System.out.println(list.toString());
        System.out.println(words.toString());
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
        //Collections.
        System.out.println(chars.toString());
        */
    }


}
