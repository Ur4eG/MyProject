package home.ur4eg.dev.dds.playWithInnerClass;

/**
 * Created by Ur4eG on 10-May-16.
 */
public class abc {
    public  int a;
    private int i;
    private Integer I;
    private int getI(){return this.i;}

    public abc(){
        System.out.println(i = 123);}

    public class Inner2{
        public Inner2(){
            changeI();
            getSuperI();
        }
        public void changeI(){abc.this.i = 234;}
        public void getSuperI(){
            System.out.println(abc.this.getI());
        }
    }

    public void createInner(){
        abc.this.new Inner2();
    }

    public static void main(String[] args) {
        abc ABC = new abc();
        ABC.createInner();
    }
}
