package com.sharankonda.elevatorrestapp.Types;

public class MoveLiftType {
    private int floor;
    private int elevator;
    private String status;

    public MoveLiftType() {

    }

    public MoveLiftType(int floor, int elevator) {
        this.floor = floor;
        this.elevator = elevator;
    }

    public int getFloor() {
        return floor;
    }

    public String getStatus() {
        return status;
    }

    public int getElevator() {
        return elevator;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setElevator(int elevator) {
        this.elevator = elevator;
    }
}
