package home.ur4eg.dev.dds.MyXML;

import java.util.List;
import java.util.concurrent.Callable;

public class Tag {
    String name;
    //Attr attr;
    String attr;
    //Set<String> attribute;
    List<Tag> innerTags;
    Tag next;
    int level;

    public Tag(String name){
        this.name = name;
    };

    public Tag(String tagName, Callable findCloseTag) throws Exception {
        name = tagName;
        findCloseTag.call();
    }



    public Tag(String tagName, String attr){
        this.name = tagName;
        //this.attr.value = attr;
    }

    public Tag(String tagName, Attr attr){
        this.name = tagName;
        //this.attr.innerTags = attr.innerTags;
    }

    public void addListener(XmlStruct xml){
        if(xml.tagName.equals("person"))
            System.out.println("wow");
    }



    public void print(Tag tag){
        printWithSpaces(name);
        if(attr != null){
            System.out.print(" "+attr+" ");
        }
        if(this.innerTags.size()>0){
            System.out.println();
            for(int i=0; i<this.innerTags.size(); i++){
                print(this.innerTags.get(i));
            }
            System.out.println();
        }
        printWithSpaces(name);
    }

    private void printWithSpaces(String value) {
        for(int i=0; i<level; i++) {
            System.out.print(' ');
        }
        System.out.print(name);
    }
}
