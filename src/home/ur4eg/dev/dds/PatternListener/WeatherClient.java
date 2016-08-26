package home.ur4eg.dev.dds.PatternListener;

import java.util.*;

/**
 * Created by Ur4eG on 15-Feb-16.
 */
public class WeatherClient implements java.util.Observer {
    private Observable observable;
    private float temperature;
    private float humidity;

    public WeatherClient(){}

    public WeatherClient(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public String toString(){
        return "Current weather forecast: T = " + temperature + " and H = " + humidity;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherStation){
            WeatherStation weatherStation = (WeatherStation)o;
            this.temperature = weatherStation.getTemperature();
            this.humidity = weatherStation.getHumidity();
            System.out.println(this);
        }
    }
}
