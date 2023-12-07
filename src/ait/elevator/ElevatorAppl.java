package ait.elevator;

import ait.elevator.model.Elevator;
import ait.elevator.task.Truck;

public class ElevatorAppl {
    private static final int N_TRUCK = 1000;
    private static final int N_RACES = 10;
    private static final int CAPACITY = 20;

    public static void main(String[] args) throws InterruptedException {
        Elevator lenin = new Elevator("lenin");
        Elevator stalin = new Elevator("stalin");
        Truck[] trucks = new Truck[N_TRUCK];
        for (int i = 0; i < trucks.length; i++) {
            trucks[i] = new Truck(N_RACES, CAPACITY, lenin,stalin);
        }
        Thread[] threads = new Thread[N_TRUCK];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(trucks[i]);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("Elevator " + lenin.getName() + " has " + lenin.getCurrentVolume());
        System.out.println("Elevator " + stalin.getName() + " has " + stalin.getCurrentVolume());
    }
}