package home.ur4eg.dev.dds.PatternListener;

/**
 * Created by Ur4eG on 15-Feb-16.
 */
public interface MyObservable {
    public void addObserver(MyObserver obs);
    public void removeObserver(MyObserver obs);
    public void notifyObservers();
    public void removeObservers();
}
