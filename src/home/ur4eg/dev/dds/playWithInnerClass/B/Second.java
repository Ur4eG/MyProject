package home.ur4eg.dev.dds.playWithInnerClass.B;

import home.ur4eg.dev.dds.playWithInnerClass.A.First;

/**
 * Created by Ur4eG on 10-May-16.
 */
public class Second {

    protected class Inner implements First {

        @Override
        public void getIt() {
            System.out.println("return interface");
        }
    }

    public First getInnerInstance(){
        return new Inner();
    }
}
