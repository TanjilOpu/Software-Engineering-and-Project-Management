import java.util.LinkedList;
import java.util.Queue;

public class ParkingPool {
    private final Queue<RegistrarParking> queue = new LinkedList<>();

    public synchronized void addParking(RegistrarParking parking) {
        queue.add(parking);
        notifyAll(); // wake up waiting agents
    }

    public synchronized RegistrarParking getParking() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // wait until new car arrives
        }
        return queue.poll();
    }
}
