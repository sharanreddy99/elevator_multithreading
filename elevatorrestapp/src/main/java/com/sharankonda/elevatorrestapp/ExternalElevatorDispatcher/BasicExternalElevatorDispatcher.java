package com.sharankonda.elevatorrestapp.ExternalElevatorDispatcher;

import com.sharankonda.elevatorrestapp.ElevatorManager.ElevatorManager;
import com.sharankonda.elevatorrestapp.ElevatorManager.Direction.Direction;

public class BasicExternalElevatorDispatcher extends ExternalElevatorDispatcher {
    public BasicExternalElevatorDispatcher(ElevatorManager[] elevatorManagers) {
        super(elevatorManagers);
    }

    public void submitRequest(int floor, Direction direction) {
        int elevatorId = firstIdle();
        if (elevatorId != -1) {
            this.elevatorManagers[elevatorId].submitRequest(floor);
        }

        elevatorId = firstMinNearby(floor, direction);
        if (elevatorId != -1) {
            this.elevatorManagers[elevatorId].submitRequest(floor);
        }

        elevatorId = firstMaxNearby(floor, direction);
        if (elevatorId != -1) {
            this.elevatorManagers[elevatorId].submitRequest(floor);
        }
    }

    public int firstMinNearby(int floor, Direction direction) {
        int minFloor = 10000000;
        int elevatorId = -1;
        for (int i = 0; i < this.elevatorManagers.length; i++) {
            if (this.elevatorManagers[i].getElevatorDirection() == direction) {
                if (direction == Direction.UP && this.elevatorManagers[i].getCurrentFloor() < floor
                        && Math.abs(this.elevatorManagers[i].getCurrentFloor() - floor) < minFloor) {
                    elevatorId = i;
                    minFloor = Math.abs(this.elevatorManagers[i].getCurrentFloor() - floor);
                } else if (direction == Direction.DOWN && this.elevatorManagers[i].getCurrentFloor() > floor
                        && Math.abs(this.elevatorManagers[i].getCurrentFloor() - floor) < minFloor) {
                    elevatorId = i;
                    minFloor = Math.abs(this.elevatorManagers[i].getCurrentFloor() - floor);
                }
            }
        }

        return elevatorId;
    }

    public int firstIdle() {
        for (int i = 0; i < this.elevatorManagers.length; i++) {
            if (this.elevatorManagers[i].getElevatorDirection() == Direction.NONE) {
                return i;
            }
        }
        return -1;
    }

    public int firstMaxNearby(int floor, Direction direction) {
        int minFloor = 10000000;
        int elevatorId = -1;
        for (int i = 0; i < this.elevatorManagers.length; i++) {
            if (this.elevatorManagers[i].getElevatorDirection() != direction
                    && this.elevatorManagers[i].getElevatorDirection() != Direction.NONE) {
                if (Math.abs(this.elevatorManagers[i].getCurrentFloor() - floor) < minFloor) {
                    elevatorId = i;
                    minFloor = Math.abs(this.elevatorManagers[i].getCurrentFloor() - floor);
                }
            }
        }

        return elevatorId;
    }
}
