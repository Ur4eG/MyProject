package home.ur4eg.dev.dds.PatternListener;

import java.awt.event.ActionListener;

/**
 * Created by Ur4eG on 15-Feb-16.
 */
public class Prog {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        weatherStation.setMeasurements(12,15);

        WeatherClient weatherClient = new WeatherClient(weatherStation);
        //weatherStation.addObserver(new WeatherClient());
        weatherStation.addObserver(new AnotherWeatherClient());

        weatherStation.setMeasurements(20,16);
        weatherStation.setMeasurements(2,5);
        weatherStation.setMeasurements(32,35);
        weatherStation.setMeasurements(10,10);
        System.out.println("delete all");
        weatherStation.deleteObservers();
        weatherStation.setMeasurements(10,10);

        MyObsServer server = new MyObsServer();
        server.setMeasurements(1,1);
        server.addObserver(new MyObsClient());
        server.setMeasurements(2,2);
        server.setMeasurements(3,3);
        server.removeObservers();
        System.out.println("removed all");
        server.setMeasurements(5,5);

    }
}
