import java.util.ArrayList;
import java.util.List;

public class Floor {
    private List<Passenger> passengersOnTheFloor = new ArrayList<>();
    private int place = 0;

    public List<Passenger> getPassengersOnTheFloor() {
        return passengersOnTheFloor;
    }

    public void setPassengersOnTheFloor(Passenger passengersOnTheFloor) {
        this.passengersOnTheFloor.add(place++, passengersOnTheFloor);
    }

    @Override
    public String toString() {
        return "Floor{"
                + " passengersOnTheFloor=" + passengersOnTheFloor
                + ", place=" + place
                + '}';
    }
}
