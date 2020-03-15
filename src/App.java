public class App {

    public static int floorQuantity = UtilGetRandom.random(20, 5);
    public static int passengersOnTheFloor = UtilGetRandom.random(10, 0);
    public static int stepCounter = 0;

    public static void main(String[] args) {

        Building building = new Building();
        Elevator elevator = new Elevator();
        ElevatorService.setPassengersOnTheFloors(building);

        System.out.println("Elevator started work.");
        System.out.println(floorQuantity + " floors in the building.");
        System.out.println(passengersOnTheFloor + " passengers on every floor.");

        while (ElevatorService.checkPassengersQuantity(building)) {
            ElevatorService.showElevatorStep(building, elevator);
            ElevatorService.boarding(building, elevator);
            stepCounter++;
        }
        System.out.println("\nElevator has finished work.");
        System.out.println("Work was finished in " + stepCounter + " steps." +
                "\nThere were " + floorQuantity * passengersOnTheFloor + " passengers on " +
                floorQuantity + " floors.");
    }
}
