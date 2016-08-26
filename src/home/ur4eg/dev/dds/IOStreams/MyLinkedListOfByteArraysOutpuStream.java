package home.ur4eg.dev.dds.IOStreams;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ur4eG on 11-Mar-16.
 */
public class MyLinkedListOfByteArraysOutpuStream extends OutputStream{
    private List<byte[]> byteStorage;
    private byte[] internalArray;
    private int bound = 5;
    private int internalArrayIndex;

    public MyLinkedListOfByteArraysOutpuStream(){
        this(16); //initial capacity
    }

    public MyLinkedListOfByteArraysOutpuStream(int capacity){
        byteStorage = new ArrayList<>(capacity);
        //internalArray = new byte[bound];
        internalArrayIndex = 0;
        byteStorage.add(new byte[bound]);
        //System.out.println(byteStorage.size());
        //System.out.println(byteStorage.get(byteStorage.size()-1).length);
        //System.out.println(internalArray.length);
    }

    @Override
    public void write(int b) throws IOException {
        /*if(internalArrayIndex == internalArray.length){
            byteStorage.add(internalArray);
            internalArray = new byte[bound];
            internalArrayIndex = 0;
            //System.out.println("add ByteArray");
        }
        internalArray[internalArrayIndex] = (byte)b;
        //System.out.println("internalArray["+internalArrayIndex+"]=" + internalArray[internalArrayIndex]);
        internalArrayIndex++;*/

        if(internalArrayIndex == byteStorage.get(byteStorage.size()-1).length){
            byteStorage.add(new byte[bound]);
            internalArrayIndex = 0;
            //System.out.println("add ByteArray");
        }
        byteStorage.get(byteStorage.size()-1)[internalArrayIndex++] = (byte)b;
        //System.out.println("internalArray["+(internalArrayIndex--)+"]=" +  byteStorage.get(byteStorage.size()-1)[internalArrayIndex++]);
    }

    public byte[] toByteArray(){
        if(byteStorage.isEmpty())
            return new byte[0];
        /*if(byteStorage.size()==1)
            return System.arraycopy(tempArray,0,resultByteArray,resultByteArrayIndex,tempArray.length);;
*/
        byte[] resultByteArray;
        int newArrayCapacity = 0;
        for(int i=0; i<byteStorage.size()-1; i++){
            newArrayCapacity += byteStorage.get(i).length;
        }
        newArrayCapacity += internalArrayIndex;
        //System.out.println("result array capacity: " + newArrayCapacity);
        resultByteArray = new byte[newArrayCapacity];

        int resultByteArrayIndex = 0;
        byte[] tempArray;
        for(int i=0; i<byteStorage.size()-1; i++){
            tempArray = byteStorage.get(i);
            //System.out.println("index=" + resultByteArrayIndex);
            //System.out.println(Arrays.toString(tempArray));
            System.arraycopy(tempArray,0,resultByteArray,resultByteArrayIndex,tempArray.length);
            resultByteArrayIndex += tempArray.length;
        }
        tempArray = byteStorage.get(byteStorage.size()-1); //last
        //System.out.println("index=" + resultByteArrayIndex);
        //System.out.println(Arrays.toString(tempArray));
        System.arraycopy(tempArray,0,resultByteArray,resultByteArrayIndex,internalArrayIndex);

        return resultByteArray;
    }
}
