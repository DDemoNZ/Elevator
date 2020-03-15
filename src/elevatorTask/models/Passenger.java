package elevatorTask.models;

import elevatorTask.Dispatcher;
import elevatorTask.utils.UtilGetRandom;

public class Passenger {

    private int neededFloor;

    public Passenger(int currentFloor) {
        this.neededFloor = UtilGetRandom.random(Dispatcher.floorQuantity, 1);
        while (neededFloor == currentFloor + 1) {
            neededFloor = UtilGetRandom.random(Dispatcher.floorQuantity, 1);
        }
    }

    public int getNeededFloor() {
        return neededFloor;
    }
}
