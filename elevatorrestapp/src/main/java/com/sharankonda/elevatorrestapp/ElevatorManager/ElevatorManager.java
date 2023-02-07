package com.sharankonda.elevatorrestapp.ElevatorManager;

import com.sharankonda.elevatorrestapp.ElevatorManager.Direction.Direction;
import com.sharankonda.elevatorrestapp.Elevator.Elevator;

public class ElevatorManager implements Runnable {
    private Elevator elevator;
    private Thread managerThread;

    public ElevatorManager(Elevator elevator, int noOfFloors) {
        this.elevator = elevator;
        this.managerThread = new Thread(this, "ElevatorManager-" + elevator);
        this.managerThread.start();
    }

    public void submitRequest(int floor) {
        this.elevator.produce(floor);
    }

    public Direction getElevatorDirection() {
        return this.elevator.getCurrentDirection();
    }

    public int getCurrentFloor() {
        return this.elevator.getCurrentFloor();
    }

    public void run() {
        this.elevator.consume();
    }
}
