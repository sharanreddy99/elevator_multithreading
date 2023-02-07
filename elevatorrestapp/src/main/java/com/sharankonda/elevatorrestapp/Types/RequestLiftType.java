package com.sharankonda.elevatorrestapp.Types;

import com.sharankonda.elevatorrestapp.ElevatorManager.Direction.Direction;

public class RequestLiftType {
    private int floor;
    private String direction;
    private String status;

    public RequestLiftType() {

    }

    public RequestLiftType(int floor, String direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public Direction getDirection() {
        Direction direction = Direction.NONE;
        if (this.direction.equals("UP")) {
            direction = Direction.UP;
        }
        if (this.direction.equals("DOWN")) {
            direction = Direction.DOWN;
        }
        return direction;
    }

    public int getFloor() {
        return floor;
    }

    public String getStatus() {
        return status;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
