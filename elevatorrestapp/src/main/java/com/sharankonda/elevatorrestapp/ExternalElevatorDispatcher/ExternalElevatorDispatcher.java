package com.sharankonda.elevatorrestapp.ExternalElevatorDispatcher;

import com.sharankonda.elevatorrestapp.ElevatorManager.ElevatorManager;
import com.sharankonda.elevatorrestapp.ElevatorManager.Direction.Direction;

public abstract class ExternalElevatorDispatcher {
    protected ElevatorManager[] elevatorManagers;

    public ExternalElevatorDispatcher(ElevatorManager[] elevatorManagers) {
        this.elevatorManagers = elevatorManagers;
    }

    public abstract void submitRequest(int floor, Direction d);

}
