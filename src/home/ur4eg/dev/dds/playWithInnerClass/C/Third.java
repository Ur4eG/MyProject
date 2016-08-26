package home.ur4eg.dev.dds.playWithInnerClass.C;

import home.ur4eg.dev.dds.playWithInnerClass.B.Second;
import home.ur4eg.dev.dds.playWithInnerClass.A.First;

/**
 * Created by Ur4eG on 10-May-16.
 */
public class Third extends Second {
    public First getFirst(){
        return getInnerInstance();
    }
}
