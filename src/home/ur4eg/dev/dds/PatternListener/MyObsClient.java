package home.ur4eg.dev.dds.PatternListener;

/**
 * Created by Ur4eG on 16-Feb-16.
 */
public class MyObsClient implements MyObserver{
    private MyObservable sender;
    private float temperature;
    private float humidity;

    public MyObsClient(){}

    public MyObsClient(MyObservable sebder){
        this.sender = sender;
        sender.addObserver(this);
    }

    @Override
    public void update(MyObservable obs) {
        if(obs instanceof MyObsServer){
            MyObsServer myObsServer = (MyObsServer)obs;
            this.temperature = myObsServer.getTemperature();
            this.humidity = myObsServer.getHumidity();
            System.out.println(this);
        }
    }

    @Override
    public String toString(){
        return "Client has received: T=" + temperature + "; H=" +humidity;
    }
}
