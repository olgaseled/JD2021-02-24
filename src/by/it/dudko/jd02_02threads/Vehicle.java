package by.it.dudko.jd02_02threads;

public class Vehicle extends Thread {
    int size;
    // int maxTimeToWaitFreePlace;

    public Vehicle(String name, int size) {
        super(name);
        this.size = size;
    }

    public int size() {
        return size;
    }

    @Override
    public void run() {
        getPlace();
        standBy();
        leave();
    }

    public void getPlace() {
        Parking.getParkingPlace(this);
    }

    public void standBy() {
        int actionTime = Util.getRandom(10000, 20000);
        Util.sleep(actionTime);
    }

    private void leave() {
        Parking.leaveParking(this);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
