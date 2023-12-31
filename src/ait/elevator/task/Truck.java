package ait.elevator.task;

import ait.elevator.model.Elevator;

public class Truck implements Runnable {
    private static Object monitor1 = new Object();
    private static Object monitor2 = new Object();
    private int nRaces;
    private int capacity;
    Elevator[] elevators;


    public Truck(int nRaces, int capacity, Elevator elevator1, Elevator elevator2) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevators = new Elevator[]{elevator1, elevator2};
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            if (hashCode() % 2 == 0) {
                synchronized (monitor1) {
                    elevators[0].add(capacity / elevators.length);
                }
                synchronized (monitor2) {
                    elevators[1].add(capacity / elevators.length);
                }
            } else {
                synchronized (monitor2) {
                    elevators[1].add(capacity / elevators.length);
                }
                synchronized (monitor1) {
                    elevators[0].add(capacity / elevators.length);
                }
            }
        }
    }
}
//Truck1.java
//        package ait.elevator.task;
//
//        import ait.elevator.model.Elevator;
//
//public class Truck1 implements Runnable {
//    static Object monitor = new Object();
//    int nRaces;
//    int capacity;
//    Elevator[] elevators;
//
//    public Truck1(int nRaces, int capacity, Elevator... elevators) {
//        this.nRaces = nRaces;
//        this.capacity = capacity;
//        this.elevators = elevators;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < nRaces; i++) {
//            synchronized (monitor) {
//                elevators[0].add(capacity / elevators.length);
//                elevators[1].add(capacity / elevators.length);
//            }
//        }
//    }
//
//}

//Truck2.java
//        package ait.elevator.task;
//
//        import ait.elevator.model.Elevator;
//
//public class Truck2 implements Runnable {
//    private static Object monitor1 = new Object();
//    private static Object monitor2 = new Object();
//    int nRaces;
//    int capacity;
//    Elevator[] elevators;
//
//    public Truck2(int nRaces, int capacity, Elevator... elevators) {
//        this.nRaces = nRaces;
//        this.capacity = capacity;
//        this.elevators = elevators;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < nRaces; i++) {
//            synchronized (monitor1) {
//                elevators[0].add(capacity / elevators.length);
//            }
//            synchronized (monitor2) {
//                elevators[1].add(capacity / elevators.length);
//            }
//        }
//    }
//}