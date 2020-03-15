package elevatorTask;

import elevatorTask.models.Building;
import elevatorTask.models.Elevator;
import elevatorTask.service.ElevatorService;
import elevatorTask.utils.UtilGetRandom;

public class Dispatcher {

    public static int floorQuantity = UtilGetRandom.random(20, 5);
    public static int passengersOnTheFloor = UtilGetRandom.random(10, 0);
    public static int stepCounter = 0;

    public static void main(String[] args) {

        Building building = new Building();
        Elevator elevator = new Elevator();
        ElevatorService.setPassengersOnTheFloors(building);

        System.out.println("elevatorTask.models.Elevator started work.");
        System.out.println(floorQuantity + " floors in the building.");
        System.out.println(passengersOnTheFloor + " passengers on every floor.");

        while (ElevatorService.checkPassengersQuantity(building)) {
            ElevatorService.showElevatorStep(building, elevator);
            ElevatorService.boarding(building, elevator);
            stepCounter++;
        }

        System.out.println("\nelevatorTask.models.Elevator has finished work."
                + "\nWork was finished in " + stepCounter + " steps.\nThere were "
                + floorQuantity * passengersOnTheFloor + " passengers on " + floorQuantity
                + " floors.");
    }
}