package com.sharankonda.elevatorrestapp.InternalElevatorDispatcher;

import com.sharankonda.elevatorrestapp.ElevatorManager.ElevatorManager;

public class BasicInternalElevatorDispatcher extends InternalElevatorDispatcher {
    public BasicInternalElevatorDispatcher(ElevatorManager[] elevatorManagers) {
        super(elevatorManagers);
    }

    public void submitRequest(int floor, int elevatorId) {
        this.elevatorManagers[elevatorId].submitRequest(floor);
    }
}
