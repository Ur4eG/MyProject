package home.ur4eg.dev.dds.BattleCity.Tanks;

import home.ur4eg.dev.dds.BattleCity.Weapons.WeaponBehavior;

/**
 * Created by Ur4eG on 15-Feb-16.
 */
public abstract class Tank {
    WeaponBehavior weaponBehavior;
    int health;
    int armor;
    int velocity;
    boolean enemy;

    public Tank(){

    }

    void death(){
        System.out.println("Death.");
    }

    void born(){
        System.out.println("Born!");
    }
}
