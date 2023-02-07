package com.sharankonda.elevatorrestapp.Elevator;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.sharankonda.elevatorrestapp.Display.Display;
import com.sharankonda.elevatorrestapp.ElevatorManager.Direction.Direction;

public class Elevator {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    private Queue<Integer> q;
    private int currentFloor;
    private int maxFloors;
    private long sleepTime;
    private Direction direction;
    private Display display;
    private int id;

    public synchronized int getCurrentFloor() {
        return this.currentFloor;
    }

    public synchronized Direction getCurrentDirection() {
        return this.direction;
    }

    private synchronized void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getId() {
        return this.id;
    }

    public Elevator(int id, Display display, int capacity, int nFloors, long sleepTime) {
        this.display = display;
        this.id = id;
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.q = new LinkedList<>();
        this.currentFloor = 0;
        this.maxFloors = nFloors;
        this.sleepTime = sleepTime;
        this.direction = Direction.NONE;
    }

    private void customSleep(long totalMilli) throws InterruptedException {
        Date date = new Date();
        long startTime = date.getTime();

        while (true) {
            date = new Date();
            long currentTime = date.getTime();
            long remaining = totalMilli - (currentTime - startTime);
            if (remaining > 0) {
                wait(remaining);
            } else {
                break;
            }
        }
    }

    public synchronized void produce(int val) {
        if (!(val >= 0 && val < this.maxFloors) || getCurrentFloor() == val)
            return;

        this.q.add(val);
        if (direction == Direction.UP) {
            customNotifyUpwards();
        } else if (direction == Direction.DOWN) {
            customNotifyDownwards();
        } else {
            customNotifyUpwards();
            if (direction == Direction.NONE)
                customNotifyDownwards();
        }
    }

    private synchronized void customNotifyUpwards() {
        int len = q.size();
        boolean isAdded = false;

        for (int i = 0; i < len; i++) {
            int poppedVal = q.poll();
            if (poppedVal > getCurrentFloor()) {
                minHeap.add(poppedVal);
                isAdded = true;
            } else {
                q.add(poppedVal);
            }
        }

        if (isAdded) {
            this.direction = Direction.UP;
            notify();
        }
    }

    private synchronized void customNotifyDownwards() {
        int len = q.size();
        boolean isAdded = false;

        for (int i = 0; i < len; i++) {
            int poppedVal = q.poll();
            if (poppedVal < getCurrentFloor()) {
                maxHeap.add(poppedVal);
                isAdded = true;
            } else {
                q.add(poppedVal);
            }
        }

        if (isAdded) {
            direction = Direction.DOWN;
            notify();
        }
    }

    public synchronized void consume() {
        try {
            while (true) {
                if (this.direction == Direction.UP) {
                    consumeUpwards();
                } else if (this.direction == Direction.DOWN) {
                    consumeDownwards();
                } else {
                    customNotifyUpwards();
                    if (direction == Direction.NONE)
                        customNotifyDownwards();
                    if (direction == Direction.NONE)
                        wait();
                }
            }

        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception in produce");
        }
    }

    private synchronized void consumeUpwards() throws InterruptedException {
        while (minHeap.size() == 0) {
            if (getCurrentFloor() > 0) {
                this.direction = Direction.NONE;
                this.display.setDisplay(direction, currentFloor, false);
                return;
            }
            wait();
        }

        customSleep(sleepTime);
        setCurrentFloor(currentFloor + 1);

        if (getCurrentFloor() < minHeap.peek()) {
            this.display.setDisplay(direction, currentFloor, false);
        } else if (getCurrentFloor() == minHeap.peek()) {
            this.display.setDisplay(direction, currentFloor, true);
            while (minHeap.size() > 0 && getCurrentFloor() == this.minHeap.peek())
                this.minHeap.poll();
        } else {
            throw new Error("Cannot reach this condition in consumeDownwards");
            // this.direction = Direction.NONE;
            // return;
        }
    }

    private synchronized void consumeDownwards() throws InterruptedException {
        while (maxHeap.size() == 0) {
            if (getCurrentFloor() >= 0) {
                this.direction = Direction.NONE;
                this.display.setDisplay(direction, currentFloor, false);
                return;
            }
            wait();
        }

        customSleep(sleepTime);
        setCurrentFloor(currentFloor - 1);

        if (getCurrentFloor() > maxHeap.peek()) {
            this.display.setDisplay(direction, currentFloor, false);
        } else if (getCurrentFloor() == maxHeap.peek()) {
            this.display.setDisplay(direction, currentFloor, true);
            while (maxHeap.size() > 0 && getCurrentFloor() == this.maxHeap.peek())
                this.maxHeap.poll();
        } else {
            throw new Error("Cannot reach this condition in consumeDownwards");
            // this.direction = Direction.NONE;
            // return;
        }
    }

    // public void setDisplay() {
    // this.display.setDisplay(this.getCurrentDirection(), this.getCurrentFloor());
    // }
}
