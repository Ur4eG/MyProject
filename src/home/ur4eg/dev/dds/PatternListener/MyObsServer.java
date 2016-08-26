package home.ur4eg.dev.dds.PatternListener;

import java.util.ArrayList;

/**
 * Created by Ur4eG on 16-Feb-16.
 */
public class MyObsServer implements MyObservable{
    private ArrayList observers;
    private float temperature;
    private float humidity;
    private boolean change;

    public MyObsServer(){
        observers = new ArrayList();
        change = false;
    }

    public float getTemperature(){
        return temperature;
    }

    public float getHumidity(){
        return humidity;
    }

    @Override
    public void addObserver(MyObserver obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(MyObserver obs) {
        if(observers.indexOf(obs) >= 0){
            observers.remove( observers.indexOf(obs) );
        }
    }

    @Override
    public void removeObservers(){
        observers.clear();
    }

    protected void setChanged(){
        change = true;
    }

    @Override
    public void notifyObservers() {
        if(change){
            for(int i=0; i<observers.size(); i++){
                ((MyObserver)observers.get(i)).update(this);
            }
            change = false;
        }
    }

    public void setMeasurements(float T, float H){
        this.temperature = T;
        this.humidity = H;
        System.out.println(this);
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString(){
        return "My ObsServer has: T=" +temperature + "; H=" + humidity;
    }
}
