package com.sharankonda.elevatorrestapp.Types;

public class BuildingType {
    private int floors;
    private int elevators;
    private long liftSpeed;
    private String status;

    public BuildingType() {

    }

    BuildingType(int floors, int elevators, long liftSpeed) {
        this.elevators = elevators;
        this.floors = floors;
        this.liftSpeed = liftSpeed;
    }

    public int getFloors() {
        return this.floors;
    }

    public int getElevators() {
        return this.elevators;
    }

    public long getLiftSpeed() {
        return liftSpeed;
    }

    public String getStatus() {
        return status;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public void setElevators(int elevators) {
        this.elevators = elevators;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLiftSpeed(long liftSpeed) {
        this.liftSpeed = liftSpeed;
    }
}
