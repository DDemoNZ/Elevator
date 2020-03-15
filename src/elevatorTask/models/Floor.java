package elevatorTask.models;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private List<Passenger> passengersOnTheFloor = new ArrayList<>();

    public List<Passenger> getPassengersOnTheFloor() {
        return passengersOnTheFloor;
    }
}
