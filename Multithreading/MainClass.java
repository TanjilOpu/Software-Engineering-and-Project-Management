import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        ParkingPool parkingPool = new ParkingPool();

        // Create 3 parking agents
        new ParkingAgent("Agent-1", parkingPool).start();
        new ParkingAgent("Agent-2", parkingPool).start();
        new ParkingAgent("Agent-3", parkingPool).start();

        Scanner sc = new Scanner(System.in);
        int carId = 1;

        while (true) {
            System.out.println("\nPress ENTER to register a new car for parking (or type -1 to exit):");

            String input = sc.nextLine();

            if (input.equals("-1")) {
                System.out.println("Exiting program...");
                break;
            }

            RegistrarParking parking = new RegistrarParking(carId);
            parkingPool.addParking(parking);

            System.out.println("New Car #" + carId + " registered for parking.");
            carId++;
        }


        sc.close();
    }
}
