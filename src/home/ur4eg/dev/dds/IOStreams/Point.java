package home.ur4eg.dev.dds.IOStreams;

/**
 * Created by Ur4eG on 28-Mar-16.
 */
public class Point {
    private final int x, y;

    public Point(int x, int y) {
        if(x<0 || x>15)
            throw new ArithmeticException();
        if(y<0 || y>15)
            throw new ArithmeticException();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
