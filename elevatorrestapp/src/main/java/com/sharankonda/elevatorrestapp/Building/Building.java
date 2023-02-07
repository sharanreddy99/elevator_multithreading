package com.sharankonda.elevatorrestapp.Building;

import com.sharankonda.elevatorrestapp.ElevatorManager.ElevatorManager;
import com.sharankonda.elevatorrestapp.ElevatorManager.Direction.Direction;

import com.sharankonda.elevatorrestapp.Display.Display;
import com.sharankonda.elevatorrestapp.Elevator.Elevator;
import com.sharankonda.elevatorrestapp.ExternalElevatorDispatcher.BasicExternalElevatorDispatcher;
import com.sharankonda.elevatorrestapp.ExternalElevatorDispatcher.ExternalElevatorDispatcher;
import com.sharankonda.elevatorrestapp.InternalElevatorDispatcher.BasicInternalElevatorDispatcher;
import com.sharankonda.elevatorrestapp.InternalElevatorDispatcher.InternalElevatorDispatcher;
import com.sharankonda.elevatorrestapp.Types.DisplayType;

public class Building implements Runnable {
    private int nFloors, nElevators;
    private Display[] displays;
    private ElevatorManager[] elevatorManagers;
    private ExternalElevatorDispatcher eed;
    private InternalElevatorDispatcher ied;
    private Thread thisThread;
    private long liftSpeed;
    // private Scanner scan;

    public Building(int nFloors, int nElevators, long liftSpeed) {
        this.nFloors = nFloors;
        this.nElevators = nElevators;
        this.liftSpeed = liftSpeed;

        initializeDisplays();
        initializeElevatorManagers();
        this.eed = new BasicExternalElevatorDispatcher(this.elevatorManagers);
        this.ied = new BasicInternalElevatorDispatcher(this.elevatorManagers);

        // scan = new Scanner(System.in);

        this.thisThread = new Thread(this, "Building x");
        this.thisThread.start();
    }

    private void initializeDisplays() {
        this.displays = new Display[this.nElevators];
        for (int i = 0; i < this.nElevators; i++) {
            this.displays[i] = new Display(i);
        }
    }

    private void initializeElevatorManagers() {
        this.elevatorManagers = new ElevatorManager[this.nElevators];
        for (int i = 0; i < this.nElevators; i++) {
            this.elevatorManagers[i] = new ElevatorManager(
                    new Elevator(i, displays[i], 16, this.nFloors, this.liftSpeed),
                    this.nFloors);
        }
    }

    // User Interacted functions
    public void requestLift(int currentFloor, Direction direction) {
        this.eed.submitRequest(currentFloor, direction);
    }

    public void showLifts() {
        for (int i = 0; i < this.nElevators; i++) {
            this.displays[i].showDisplay();
        }
    }

    public DisplayType[] getLifts() {
        DisplayType[] displaysList = new DisplayType[this.nElevators];
        for (int i = 0; i < this.nElevators; i++) {
            displaysList[i] = this.displays[i].getDisplay();
        }

        return displaysList;
    }

    public void goToFloorByLift(int floor, int elevatorId) {
        this.ied.submitRequest(floor, elevatorId);
    }

    public void run() {
        // while (true) {
        // System.out.printf("\n\nWelcome to Building X with %d floors and %d
        // elevators!!!\n", this.nFloors,
        // this.nElevators);
        // System.out.println("--------------------------------------------------------");
        // System.out.printf(
        // "Choose option:\n1) Show Lifts\n\n2) Request Lift(floorno, direction)\n\n3)
        // Move Lift(elevatorId, floorno)\n\nFloor - 1 to %d\nDirection - 1(UP) or
        // 2(DOWN)\n\n",
        // this.nFloors);

        // String[] input = scan.nextLine().split(" ");
        // try {
        // if (input.length == 1 && input[0].equals("1")) {
        // showLifts();
        // } else if (input.length == 3 && input[0].equals("2")) {
        // int floor = Integer.parseInt(input[1]);
        // Direction d = Direction.UP;
        // if (Integer.parseInt(input[2]) == 2) {
        // d = Direction.DOWN;
        // }

        // requestLift(floor, d);
        // } else if (input.length == 4 && input[0].equals("3")) {
        // int elevatorId = Integer.parseInt(input[1]);
        // int floorId = Integer.parseInt(input[2]);
        // goToFloorByLift(floorId, elevatorId);
        // }
        // } catch (Exception e) {
        // System.out.println("Invalid option entered. Try again!!");
        // }
        // }
    }
}
