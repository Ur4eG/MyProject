package home.ur4eg.dev.dds.playWithInnerClass.D;

import home.ur4eg.dev.dds.Prog_1;

public class prog{
    public static void main(String[] args) {
        System.out.println(prog1.j);
        prog1 p1 = new prog1();
        //some a = p1.getInner();
        //Prog_1.Inner b = a;

    }
}

class prog1 {
    private int i;
    static int j;
     class Inner implements some {

        @Override
        public void Aa() {
            System.out.println("inner implements method");
        }
    }

    {
        System.out.println("simple init");
    }

    static{
        System.out.println("static init");
    }

    public prog1(){
        System.out.println("init prog constructor");
    }

    public some getInner(){
        System.out.println("getting instance of Inner");

        return new Inner();

    }
}
