import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ElevatorService {

    public static void setPassengersOnTheFloors(Building building) {
        List<Floor> buildingFloors = building.getFloorsOfBuilding();
        for (int i = 0; i < App.floorQuantity; i++) {
            Floor floor = new Floor();
            List<Passenger> passengers = floor.getPassengersOnTheFloor();
            for (int j = 0; j < App.passengersOnTheFloor; j++) {
                passengers.add(new Passenger(i));
            }
            buildingFloors.add(i, floor);
        }
    }

    public static void showElevatorStep(Building building, Elevator elevator) {
        List<Floor> floorList = building.getFloorsOfBuilding();
        List<Passenger> elevatorPassengers = elevator.getPassengers();
        System.out.println("\n                  Step " + App.stepCounter);
        for (int i = App.floorQuantity - 1, n = App.floorQuantity; i >= 0; i--, n--) {
            List<Passenger> floor = floorList.get(i).getPassengersOnTheFloor();
            System.out.print("Floor " + n + " - ");
            for (int j = 0; j < App.passengersOnTheFloor; j++) {
                if (floor.get(j) == null) {
                    System.out.printf("%4s", " ");
                } else {
                    System.out.printf("%4d", floor.get(j).getNeededFloor());
                }
            }
            System.out.print(" | ");
            if (elevator.getElevatorDirection() == ElevatorDirection.UP
                    && elevator.getCurrentFloor() == n) {
                System.out.print("^");
                for (int j = 0; j < elevator.getCurrentCapacity(); j++) {
                    if (elevator.getPassengers().get(j) != null) {
                        System.out.printf("%4d", elevatorPassengers.get(j).getNeededFloor());
                    }
                }
            } else if (elevator.getElevatorDirection() == ElevatorDirection.DOWN
                    && elevator.getCurrentFloor() == n) {
                System.out.print("V");
                for (int j = 0; j < elevator.getCurrentCapacity(); j++) {
                    if (elevator.getPassengers().get(j) != null) {
                        System.out.printf("%4d", elevatorPassengers.get(j).getNeededFloor());
                    }
                }
            }
            System.out.println();
        }
    }

    public static void boarding(Building building, Elevator elevator) {
        List<Passenger> passengers = elevator.getPassengers();
        List<Passenger> floor =
                building.getFloorsOfBuilding().get(elevator.getCurrentFloor() - 1)
                        .getPassengersOnTheFloor();
        passengerEnterIntoElevator(elevator, floor);
        elevatorMoving(elevator);
        passengerOutFromElevator(elevator, passengers);
    }

    private static void passengerEnterIntoElevator(Elevator elevator, List<Passenger> floor) {
        if (elevator.getCurrentFloor() == 1 ||
                elevator.getElevatorDirection() == ElevatorDirection.UP
                && elevator.getCurrentFloor() != App.floorQuantity) {
            for (int i = 0; i < App.passengersOnTheFloor; i++) {
                if (floor.get(i) != null
                        && floor.get(i).getNeededFloor() >= elevator.getCurrentFloor()
                        && elevator.getCurrentCapacity() < elevator.getMaxCapacity()) {
                    elevator.addPassengers(floor.get(i));
                    floor.set(i, null);
                }
            }
        } else if (elevator.getElevatorDirection() == ElevatorDirection.DOWN
                || elevator.getCurrentFloor() == App.floorQuantity) {
            for (int i = 0; i < App.passengersOnTheFloor; i++) {
                if (floor.get(i) != null
                        && floor.get(i).getNeededFloor() <= elevator.getCurrentFloor()
                        && elevator.getCurrentCapacity() < elevator.getMaxCapacity()) {
                    elevator.addPassengers(floor.get(i));
                    floor.set(i, null);
                }
            }
        }
    }

    private static void passengerOutFromElevator(Elevator elevator, List<Passenger> passengers) {
        for (int i = 0; i < passengers.size(); i++) {
            if (elevator.getPassengers().get(i) == null
                    || elevator.getPassengers().get(i).getNeededFloor()
                    == elevator.getCurrentFloor()) {
                elevator.getPassengers().remove(i);
                i--;
                elevator.setCurrentCapacity(elevator.getCurrentCapacity() - 1);
            }
        }
    }

    public static void elevatorMoving(Elevator elevator) {
        if (elevator.getElevatorDirection() == ElevatorDirection.UP) {
            if (elevator.getCurrentFloor() != App.floorQuantity) {
                elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
            } else if (elevator.getCurrentFloor() == App.floorQuantity) {
                elevator.setElevatorDirection(ElevatorDirection.DOWN);
            } else if (elevator.getCurrentFloor() + 1 >= App.floorQuantity) {
                elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
                elevator.setElevatorDirection(ElevatorDirection.DOWN);
            }
        } else if (elevator.getElevatorDirection() == ElevatorDirection.DOWN) {
            if (elevator.getCurrentFloor() - 1 != 0) {
                elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
            } else {
                elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
                elevator.setElevatorDirection(ElevatorDirection.UP);
            }
        }
    }

    public static boolean checkPassengersQuantity(Building building) {
        long checkPassengersQuantity = building.getFloorsOfBuilding().stream()
                .map(Floor::getPassengersOnTheFloor)
                .flatMap(Collection::stream)
                .collect(Collectors.toList())
                .stream()
                .filter(Objects::nonNull)
                .count();
        return checkPassengersQuantity != 0;
    }
}
