import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {
    private String licensePlate;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}

class ParkingSpace {
    private boolean occupied;
    private Car parkedCar;

    public ParkingSpace() {
        this.occupied = false;
        this.parkedCar = null;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public void parkCar(Car car) {
        this.occupied = true;
        this.parkedCar = car;
    }

    public void vacate() {
        this.occupied = false;
        this.parkedCar = null;
    }
}

class ParkingLot {
    private List<ParkingSpace> parkingSpaces;

    public ParkingLot(int numSpaces) {
        parkingSpaces = new ArrayList<>();
        for (int i = 0; i < numSpaces; i++) {
            parkingSpaces.add(new ParkingSpace());
        }
    }

    public boolean parkCar(Car car) {
        for (ParkingSpace space : parkingSpaces) {
            if (!space.isOccupied()) {
                space.parkCar(car);
                return true;
            }
        }
        return false; // No available space
    }

    public void vacateSpace(int spaceNumber) {
        if (spaceNumber >= 0 && spaceNumber < parkingSpaces.size()) {
            parkingSpaces.get(spaceNumber).vacate();
            System.out.println("Parking space " + spaceNumber + " vacated.");
        } else {
            System.out.println("Invalid parking space number.");
        }
    }

    public void displayParkingLot() {
        for (int i = 0; i < parkingSpaces.size(); i++) {
            ParkingSpace space = parkingSpaces.get(i);
            System.out.println("Space " + i + ": " + (space.isOccupied() ? "Occupied" : "Vacant"));
            if (space.isOccupied()) {
                System.out.println("  Car License Plate: " + space.getParkedCar().getLicensePlate());
            }
        }
    }
}

public class CarParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the number of parking spaces: ");
            int numSpaces = scanner.nextInt();
            ParkingLot parkingLot = new ParkingLot(numSpaces);

            while (true) {
                System.out.println("\n1. Park a car");
                System.out.println("2. Vacate a parking space");
                System.out.println("3. Display parking lot");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter car license plate: ");
                        String licensePlate = scanner.next();
                        Car car = new Car(licensePlate);
                        if (parkingLot.parkCar(car)) {
                            System.out.println("Car parked successfully.");
                        } else {
                            System.out.println("Parking lot is full. Cannot park the car.");
                        }
                        break;

                    case 2:
                        System.out.print("Enter the parking space number to vacate: ");
                        int spaceNumber = scanner.nextInt();
                        parkingLot.vacateSpace(spaceNumber);
                        break;

                    case 3:
                        parkingLot.displayParkingLot();
                        break;

                    case 4:
                        System.out.println("Exiting the car parking system. Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        } finally {
            // Close the scanner in a finally block to ensure it's always closed
            scanner.close();
        }
    }
}
