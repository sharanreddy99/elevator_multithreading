package com.sharankonda.elevatorrestapp.InternalElevatorDispatcher;

import com.sharankonda.elevatorrestapp.ElevatorManager.ElevatorManager;

public abstract class InternalElevatorDispatcher {
    protected ElevatorManager[] elevatorManagers;

    public InternalElevatorDispatcher(ElevatorManager[] elevatorManagers) {
        this.elevatorManagers = elevatorManagers;
    }

    public abstract void submitRequest(int floor, int elevatorId);

}
