package home.ur4eg.dev.dds.IOStreams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Ur4eG on 12-Mar-16.
 */
public class FSTree {
    public final static String PATH = "D:\\Изображения\\";
    public static int shift = 0;

    public static void main(String[] args) {
        File file = new File(PATH);
        System.out.println(recursiveFSTreeRun(file));
        //System.out.println(file.length());
    }

    public static long recursiveFSTreeRun(File path){
        if(path.isFile())
            return path.length();
        File[] listFiles = path.listFiles(
                /*(pathname)->{
                    if(pathname.isFile())
                        getMIME(pathname.toPath()).startsWith("image");
                    return pathname.isDirectory(); }*/
        );
        long len = 0;
        for(File f: listFiles){
            if(f.isDirectory())
                len += recursiveFSTreeRun(f);
            else
                len += f.length();
        }
        shift++;
        for(int i=0;i<shift; i++){
            System.out.print(" ");
        }
        System.out.print(path.getName() + "\t" + len+"\n");
        shift--;
        return len;
    }

    public static String getMIME(Path path){
        String s = null;
        try {
            s = Files.probeContentType(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}
