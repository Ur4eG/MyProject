package home.ur4eg.dev.dds.PatternListener;

import java.util.Observable;

/**
 * Created by Ur4eG on 15-Feb-16.
 */
public class WeatherStation extends Observable /*implements Subject*/{
    private float temperature;
    private float humidity;

    public WeatherStation(){}

    public float getTemperature(){
        return temperature;
    }

    public float getHumidity(){
        return humidity;
    }

    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity){
        this.temperature = temperature;
        this.humidity = humidity;
        System.out.println(this);
        measurementsChanged();
    }

    /*@Override
    protected void setChanged(){}*/

    @Override
    public String toString(){
        return "Weather station has new data: T=" + temperature + "; H=" + humidity;
    }
}
