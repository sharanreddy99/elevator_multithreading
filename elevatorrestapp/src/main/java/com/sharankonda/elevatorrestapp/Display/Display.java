package com.sharankonda.elevatorrestapp.Display;

import com.sharankonda.elevatorrestapp.ElevatorManager.Direction.Direction;
import com.sharankonda.elevatorrestapp.Types.DisplayType;

public class Display {
    private int floor;
    private Direction direction;
    private int elevatorId;
    private boolean isBoarding;

    public Display(int elevatorId) {
        this.elevatorId = elevatorId;
        this.floor = 1;
        this.direction = Direction.NONE;
        this.isBoarding = false;
    }

    public void showDisplay() {
        if (this.isBoarding) {
            System.out.printf("Person moving into or out of Elevator %d is at floor %d\n", this.elevatorId, this.floor);
        } else {
            if (this.direction == Direction.UP) {
                System.out.printf("Elevator %d is at floor %d and going up\n", this.elevatorId, this.floor);
            } else if (this.direction == Direction.DOWN) {
                System.out.printf("Elevator %d is at floor %d and going down\n", this.elevatorId, this.floor);
            } else {
                System.out.printf("Elevator %d is idle at floor %d\n", this.elevatorId, this.floor);
            }
        }
    }

    public DisplayType getDisplay() {
        return new DisplayType(floor, elevatorId, isBoarding, direction);
    }

    public void setDisplay(Direction d, int floor, boolean isBoarding) {
        this.direction = d;
        this.floor = floor;
        this.isBoarding = isBoarding;
    }
}
