package com.sharankonda.elevatorrestapp.Types;

import com.sharankonda.elevatorrestapp.ElevatorManager.Direction.Direction;

public class DisplayType {
    private int floor;
    private String direction;
    private int elevator;
    private boolean isBoarding;

    public DisplayType() {

    }

    public DisplayType(int floor, int elevator, boolean isBoarding, Direction direction) {
        this.floor = floor;
        this.elevator = elevator;
        this.isBoarding = isBoarding;
        this.setDirection(direction);
    }

    public String getDirection() {
        return direction;
    }

    public int getElevator() {
        return elevator;
    }

    public int getFloor() {
        return floor;
    }

    public boolean getBoardingStatus() {
        return this.isBoarding;
    }

    public void setBoardingStatus(boolean isBoarding) {
        this.isBoarding = isBoarding;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setElevator(int elevator) {
        this.elevator = elevator;
    }

    public void setDirection(Direction direction) {
        this.direction = "NONE";
        if (direction == Direction.UP) {
            this.direction = "UP";
        }
        if (direction == Direction.DOWN) {
            this.direction = "DOWN";
        }
    }
}
