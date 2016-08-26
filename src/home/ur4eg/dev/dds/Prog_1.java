package home.ur4eg.dev.dds;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ServiceLoader;

public class Prog_1 {


    public static void main(String[] args) {

        ServiceLoader<Driver> loadedDrivers = ServiceLoader.load(Driver.class);
        Iterator driversIterator = loadedDrivers.iterator();
        while(driversIterator.hasNext()){
            System.out.println(driversIterator.next());
        }


    }
}

