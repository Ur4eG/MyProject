package home.ur4eg.dev.dds.PatternListener;

import java.util.*;

/**
 * Created by Ur4eG on 16-Feb-16.
 */
public class AnotherWeatherClient implements java.util.Observer {
    Observable observable;
    private float T;
    private float H;

    public AnotherWeatherClient(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    public AnotherWeatherClient(){}

    @Override
    public String toString(){
        return "Another Client report: T=" + T + "; H=" + H;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherStation){
            WeatherStation weatherStation = (WeatherStation)o;
            this.T = weatherStation.getTemperature();
            this.H = weatherStation.getHumidity();
            System.out.println(this);
        }
    }
}
