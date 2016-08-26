package home.ur4eg.dev.dds.MyXML;

import java.io.*;
import java.util.*;
import java.util.concurrent.Callable;

/**поиск тега:
 * 1)пропускаем пробелы и перенос строки пока не найдем символ '<'
 * 2)считываем Тег
 * 3)теперь нужно считать всё пока не встретим Закрывающий Тег
 *      а)если считали значение, тогда ищем ЗТ - п.4
 *      б)если считали символ '<', тогда п.2
 *      в)иначе Пустой Тег - исключение
 * 4)
 */
public class XmlStruct {
    Tag tag;
    String tagName = "";
    Reader in;

    public XmlStruct(Reader in){
        this.in = in;
    }

    StringBuilder buffer = new StringBuilder();
    private void BufReader(Reader in) throws IOException {
        int size = 50;
        int c;
        buffer = new StringBuilder();
        for(int i=0; i<size && (c=in.read()) != 0; i++){
            buffer.append((char)c);
        }
    }

    public void readOpenTag(Reader in) throws IOException {
        StringBuilder sb = new StringBuilder();
        tag.addListener(this);
       // boolean headTag = false;
       // boolean isValue = false;
        //String tagName = null;
        Attr attr = null;
        //passThruSpaces(in);
        int c=in.read();
        while(c > -1 && c == ' '){
            c=in.read();
        }
        while(c != -1){
            if(c=='<'){
                StringBuilder tag = new StringBuilder();
                while((c = in.read()) != -1 && c != '>'){     // not works with quoted '>' as part of value
                    tag.append((char)c);
                }
                this.tagName = tag.toString();
                System.out.println(tagName);
                //Tag tag = new Tag(sb.toString(),re);
                //readClosedTag()

            }
            c=in.read();
        }
       //return new Tag(tagName, attr);
    }

    public Attr readAttr(Reader in) throws IOException {
        Attr attr = null;
        String tagName;
        int c = in.read();
        while(c != -1){
            if(c=='<') {
                attr.innerTags = new ArrayList<>();
                tagName = readTag(in);
                attr = readAttr(in);
                attr.innerTags.add(new Tag(tagName,attr));
            }
        }
        return attr;
    }

    private static void passThruSpaces(Reader in) throws IOException {
        int c;
        c=in.read();
        while(c != -1 && c != ' '){
            c=in.read();
        }
    }


    private int c;
    private int deep = 0;

    private String readTag(Reader in) throws IOException {
        StringBuilder sb = new StringBuilder();
        c = in.read();
        while(c != -1 && c != '>'){     // not works with quoted '>' as part of value
            sb.append((char)c);
            c = in.read();
        }
        return  sb.toString();
    }

    private void analyzeTag(StringBuilder sb){
        boolean quitedString = false;
        boolean isTailTag = false;
        String name;
        trimString(sb);
        if(sb.charAt(0) == '/') {
            isTailTag = true;
        }
    }

    private void analyzeValue(StringBuilder sb){
        trimString(sb);
    }

    private void trimString(StringBuilder sb){
        while(sb.charAt(0) == ' ') sb.deleteCharAt(0);
        while(sb.charAt(sb.length()-1) == ' ') sb.deleteCharAt(sb.length()-1);
    }

    private void readOuterParam(Reader in) throws IOException {
        StringBuilder sb = new StringBuilder();
        c = in.read();
        while(c != -1 && c != '<'){
            sb.append((char)c);
            c = in.read();
        }
        trimString(sb);
        if(sb.length()==0) {
            System.out.println();
         //   n.innerProperties = new LinkedList<>();
        }
        else {
            System.out.print(sb.toString() + " ");
           // n.Property = sb.toString();
            readTag(in);
        }
    }

    public void readXml() throws Exception {
        String firstTag;
        String attrValue;
        boolean fullTag = false;
        c = in.read();
        while(c==' ' || c=='\n'){
            c = in.read();
        }
        if(c==-1)
            throw new EOFException("no data found");
        if(c!='<')
            throw new IllegalArgumentException("bad symbol");
        /**предполагается, что сейчас курсор стоит в позиции '<'
        */
        StringBuilder sb = new StringBuilder();
        while((c=in.read()) != '>'){
            //c = in.read();
            if(c==-1)
                throw new EOFException("wrong format file");
            sb.append((char)c);
        }//считали тег
        trimString(sb);
        firstTag = sb.toString();
        System.out.println(firstTag);
        if(isOneStringTag(sb))
            this.tag = disassembleTag(sb);
        else{
            sb = new StringBuilder();
           // for(c=in.read(); c==' ' || c=='\n'; c=in.read()){}
            c = in.read();
            while(c==' ' || c=='\n'){
                c = in.read();
            }
            while(!fullTag){

                if(c==-1)
                    throw new EOFException("wrong format file. EOF");
                /**здесь мы должны встретить либо значение тега(атрибута)
                 * либо текущий Тег
                 * либо новый Тег
                 */
                c = in.read();
                while (c!='<'){
                    sb.append((char)c); // means Value
                    c = in.read();
                    if(c==-1) throw new EOFException("wrong format file. EOF");
                }
                if(sb.length()>0){ //Если есть значение аттрибута
                    trimString(sb);
                    attrValue = sb.toString();
                    System.out.println("attr=" + attrValue);
                }

                sb = new StringBuilder();
                while(c!='>'){
                    sb.append((char)c);
                    c = in.read();
                    if(c==-1) throw new EOFException("wrong format file. EOF");
                }
                trimString(sb);
                if(sb.length()>0){
                    System.out.println(sb.toString());
                    if(sb.charAt(1)=='/'){
                        sb.deleteCharAt(1);
                        if(sb.equals(firstTag))
                            fullTag = true;
                        else throw new IllegalArgumentException("another Tag found where should be closed Tag");
                    }else throw new IllegalArgumentException("another Tag found where should be not");
                }else throw new IllegalArgumentException("2nd tag is empty");

            }
        }

    }

    public boolean isOneStringTag(StringBuilder s){
        if(s.charAt(s.length()-1)=='/'){
            /*if(s.length()==1 || s.indexOf("<")>0 || (s.indexOf("/")>0 && s.indexOf("/")<s.length()-1)
                throw new IllegalArgumentException("bad argument or symbol");*/
            return true;
        }
        else
            return false;
    }

    public Tag disassembleTag(StringBuilder s){
        String tagName;
        String attrName;
        String attrValue;
        //Map<String,String> attributes = new TreeMap<>();
        int i = Math.min(s.indexOf(" ")-1, s.indexOf("\n")-1);
        tagName = s.substring(0, i);
        Tag tag = new Tag(tagName);
        tag.innerTags = new ArrayList<>();
        Tag childTag;
        while(i++ < s.length()-1){
            int tmp = Math.min(s.indexOf(" ")-1, s.indexOf("=")-1);
            attrName = s.substring(i,tmp);
            i = tmp;
            tmp = s.indexOf(" ")-1;
            attrValue = s.substring(i,tmp);
            //attributes.put(attrName, attrValue);
            childTag = new Tag(attrName, attrValue);
            tag.innerTags.add(childTag);
        }
        return tag;
    }

    //читает после знака '<' до '>'
    private void readTag2() throws IOException {
        StringBuilder sb = new StringBuilder();
        while((c=in.read()) != '>'){
            if(c==-1) // тэг не закончился
                throw new EOFException("файл поврежден");
            else
                sb.append((char)c);
        }//тэг вычитан
        trimString(sb);
        if(sb.length()==0)
            throw new IllegalArgumentException("empty tag");
        tag = new Tag(sb.toString());
        if(sb.charAt(sb.length()-1)=='/'){
            tag.attr = sb.substring(sb.indexOf(" ")+1);
        }
        else{

        }
    }


    Callable findCloseTag = new Callable() {
        @Override
        public Object call() throws Exception {
           // findCloseTag0();
            return null;
        }
    };

    //читает до '<'
    //если длина прочитаного больше 0, тогда это значение тэга.
    //если = 0, тогда это означает что следует вложеный тэг
    public void findCloseTag0(Tag t) throws IOException {
        StringBuilder sb = new StringBuilder();
        while ((c=in.read()) != '<'){
            if(c==-1)
                throw new EOFException("file corrupted");
            sb.append((char)c); // считываем атрибут
        }
        trimString(sb);
        if(sb.length()>0){
            tag.attr = sb.toString();  // записываем атрибут
        }
        else {
            //tag.innerTags.add(new Tag(readTag2()));
        }


    }

}
