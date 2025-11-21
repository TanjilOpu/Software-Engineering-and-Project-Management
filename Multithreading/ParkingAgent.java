public class ParkingAgent extends Thread {
    private final ParkingPool parkingPool;
    private final String agentName;

    public ParkingAgent(String name, ParkingPool pool) {
        this.agentName = name;
        this.parkingPool = pool;
    }

    @Override
    public void run() {
        while (true) {
            try {
                RegistrarParking parking = parkingPool.getParking();
                System.out.println(agentName + " is parking Car #" + parking.getCarId());

                Thread.sleep(1000); // simulating parking time

                System.out.println(agentName + " finished parking Car #" + parking.getCarId());
            }
            catch (InterruptedException e) {
                System.out.println(agentName + " interrupted!");
                break;
            }
        }
    }
}
