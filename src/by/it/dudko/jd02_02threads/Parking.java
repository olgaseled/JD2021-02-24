package by.it.dudko.jd02_02threads;

class Parking {

    private static final Integer parkingCapacity = 15;
    private static int occupiedPlaces = 0;






    public static void getParkingPlace(Vehicle vehicle) {
        synchronized (parkingCapacity) {
            while (occupiedPlaces + vehicle.size() > parkingCapacity) {
                System.out.print(vehicle + " should wait for a vacant place\n");
                try {
                    parkingCapacity.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            occupiedPlaces += vehicle.size();
            System.out.printf("%s took %d places\n", vehicle, vehicle.size());
        }
    }

    public static void leaveParking(Vehicle vehicle) {
        synchronized (parkingCapacity) {
            System.out.printf("%s free %d places\n", vehicle, vehicle.size());
            occupiedPlaces -= vehicle.size();
            parkingCapacity.notify();
        }
    }
}
