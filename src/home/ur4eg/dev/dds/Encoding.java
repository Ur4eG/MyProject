package home.ur4eg.dev.dds;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by Ur4eG on 04-Mar-16.
 */
public class Encoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
       /* byte [] b = new byte[256];
        for(int i=0; i<256; i++){
            b[i] = (byte)(i-128);
        }

        for(String ch : Charset.availableCharsets().keySet()){
        String s = new String(b, ch);
        System.out.println(s);
        }*/
        InputStream is = null;
        try {
            is = new URL("http://lenta.ru").openStream();
            Reader reader = new InputStreamReader(is,"windows-1251");
            char[] buff = new char[16];
            int count;
            while((count=reader.read(buff)) != -1){
                System.out.print(new String(buff, 0, count));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(is != null)
                try {
                    is.close();
                } catch (IOException e) {
                    //NOP
                }
        }

    }
}
