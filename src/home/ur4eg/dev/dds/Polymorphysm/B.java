package home.ur4eg.dev.dds.Polymorphysm;

/**
 * Created by Ur4eG on 19-Feb-16.
 */
public class B extends A {
    //float j = 1;
    int l  = -555;
    public B(){
        //super();
        System.out.println("Constructor of SUB class");
    }

    public int getSuper_a(){
        return super.a;
    }

    public void something(){
        System.out.println("from B");
    }
}
