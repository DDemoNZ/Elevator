import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private int maxCapacity;
    private List<Passenger> elevatorPassengers;
    private int currentCapacity;
    private int currentFloor;
    private ElevatorDirection elevatorDirection;

    public Elevator() {
        maxCapacity = 5;
        elevatorPassengers = new ArrayList<>(5);
        elevatorDirection = ElevatorDirection.UP;
        currentCapacity = 0;
        currentFloor = 1;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public List<Passenger> getPassengers() {
        return elevatorPassengers;
    }

    public void addPassengers(Passenger passenger) {
        elevatorPassengers.add(currentCapacity++, passenger);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public ElevatorDirection getElevatorDirection() {
        return elevatorDirection;
    }

    public void setElevatorDirection(ElevatorDirection elevatorDirection) {
        this.elevatorDirection = elevatorDirection;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }
}
