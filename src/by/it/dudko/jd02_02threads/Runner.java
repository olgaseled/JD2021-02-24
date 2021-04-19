package by.it.dudko.jd02_02threads;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>(20);
        for (int i = 1; i < 20; i++) {
            Vehicle vehicle = Util.getRandom(1, 2) % 2 == 0 ? new Truck(i) : new Car(i);
            vehicles.add(vehicle);
            vehicle.start();
        }
        Util.sleep(1000);
        System.out.println("All cars created");
        for (Vehicle vehicle : vehicles) {
            try {
                vehicle.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("End of main program");
    }
}
