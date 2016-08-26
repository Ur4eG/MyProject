package home.ur4eg.dev.dds.PatternStrategy;

/**
 * Created by Ur4eG on 16-Feb-16.
 */
abstract class Something{
    FlyBehavior flyBehavior;
    NoiseBehavior noiseBehavior;

    Something(/*FlyBehavior flyBehavior*/){
        //this.fly = flyBehavior;
    }

    void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }

    void setNoiseBehavior(NoiseBehavior nb){
        noiseBehavior = nb;
    }

    void performFly(){
        flyBehavior.fly();
    }

    void performNoise(){
        noiseBehavior.noise();
    }

    public abstract void display();
}
