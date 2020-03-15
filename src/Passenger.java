public class Passenger {
    private int neededFloor;

    public Passenger(int currentFloor) {
        this.neededFloor = UtilGetRandom.random(App.floorQuantity, 1);
        while (neededFloor == currentFloor + 1) {
            neededFloor = UtilGetRandom.random(App.floorQuantity, 1);
        }
    }

    public int getNeededFloor() {
        return neededFloor;
    }
}
