import java.util.*;

public class car11 {
    public static void main(String args[]) {
        LinkedList<vehicle> list1 = new LinkedList<>();
        LinkedList<vehicle> list2 = new LinkedList<>();

        Scanner in = new Scanner(System.in);
        System.out.println("\t*****WELCOME TO COMFORT CAR PARKING *****");
        System.out.println("\t  NAME: ABM GROUPS ");
        System.out.println("\t  Reg#: 151CS");
        System.out.println("\t  RollNo: 202,125,198 ");
        System.out.println("\nCar Park contains: " + list1);

        int inputNum1 = 0;
        try {
            while (true) {
                System.out.println("\n1. Enter Garage\n2. Exit from garage\n3. Display Car List\n4. Exit menu");
                inputNum1 = in.nextInt();
                switch (inputNum1) {
                    case 1:
                        enterGarage(list1, list2);
                        break;
                    case 2:
                        exitGarage(list1, list2);
                        break;
                    case 3:
                        displayCarList(list1, list2);
                        break;
                    case 4:
                        System.out.println("Have a nice day");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please enter a valid option.");
                }
            }
        } catch (Exception e) {
            System.out.println(e + " You may have entered a wrong character. Please check.");
        }
    }

    private static void enterGarage(LinkedList<vehicle> list1, LinkedList<vehicle> list2) {
        if (list1.size() <= 9) {
            int numOfCars = 0;
            for (vehicle v : list1) {
                numOfCars = v.no;
            }
            System.out.println("\nCar numbers in the Car Park now: " + numOfCars);
            System.out.println("Car Park has another: " + (10 - numOfCars) + " vacancies");
            System.out.println("\t...Please come next car...");
            System.out.println("Car number " + (list1.size() + 1) + " is the next to enter the garage");
            System.out.print("Enter the car number given above: ");
            Scanner in = new Scanner(System.in);
            int carNum1 = in.nextInt();
            if ((list1.size() + 1) == carNum1) {
                list1.add(new vehicle(carNum1));
            } else {
                System.out.println("Please enter the correct car number");
            }
        } else {
            System.out.println("\nSorry!!!!");
            System.out.println("No parking space available. Please wait until a vacancy comes");

            for (vehicle v : list2) {
                System.out.print(v.no + " ");
            }
            System.out.println("  Cars are waiting to enter the garage");
            System.out.println("Would you like to enter the waiting list???");
            System.out.println("1. Yes\n2. No");
            Scanner in = new Scanner(System.in);
            int inputNum2 = in.nextInt();

            switch (inputNum2) {
                case 1:
                    System.out.println("Car number " + (list2.size() + 11) + " is the next to enter the garage");
                    System.out.print("Enter the car number given above: ");
                    int waitingCarNum = in.nextInt();
                    if ((list2.size() + 11) == waitingCarNum) {
                        for (int i = 0; i < list2.size() - 1; i++) {
                            vehicle temp = list2.get(i);
                            System.out.println(temp.no);
                        }
                        list2.add(new vehicle(waitingCarNum));
                        System.out.println("Waiting List ");
                        for (int i = 0; i < list2.size() - 1; i++) {
                            System.out.print(list2.get(i).no + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("Please enter the correct car number");
                    }
                    break;

                case 2:
                    System.out.println("Thank you");
                    break;
            }
        }
    }

    private static void exitGarage(LinkedList<vehicle> list1, LinkedList<vehicle> list2) {
        System.out.println("1. Depart from main garage\n2. Depart From Waiting List");
        Scanner in = new Scanner(System.in);
        int inputNum3 = in.nextInt();

        try {
            switch (inputNum3) {
                case 1:
                    if (list1.size() == 0) {
                        System.out.println("Garage is empty. If you wish, you can Enter your car now");
                    } else {
                        System.out.println("Car numbers in the Car park. Choose yours: ");
                        for (vehicle v : list1) {
                            System.out.println("in Park " + v.no);
                        }

                        System.out.println("Enter the number of your car");
                        int removeCar = in.nextInt();
                        int which = removeCar;

                        for (int h = 0; h < list1.size(); h++) {
                            vehicle v = list1.get(h);
                            if (v.no != which) {
                                v = list1.get(h);
                                continue;
                            } else {
                                for (int u = 0; u < list1.size() - 1; u++) {
                                    vehicle kl = list1.get(u);
                                    if (kl.no != which) {
                                        kl.mvs += 2;
                                    } else
                                        break;
                                }
                                for (int v = list1.size(); (list1.get(h).no != which); v--) {
                                    list1.get(h).mvs += 1;
                                }
                                System.out.println("Moves " + list1.get(h).incmoves(1));
                                list1.remove(h);
                                break;
                            }
                        }

                        if (list2.size() > 0) {
                            System.out.println("So car number " + list2.getFirst() + " to car park:");
                            list1.add(new vehicle(list2.getFirst().no));
                            list2.remove(0);
                            System.out.println("New car list in car park: " + list1);
                            System.out.println();
                        } else {
                            System.out.println("No cars in the waiting list to enter the garage");
                        }
                    }
                    break;

                case 2:
                    if (list2.size() == 0) {
                        System.out.println("There are no cars waiting in the list");
                    } else {
                        System.out.println("Cars in the waiting list: " + list2);
                        System.out.print("Enter your car number: ");
                        int removeWaitCar = in.nextInt();
                        // Implement removal logic from the waiting list
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println("You have entered a wrong Index number. Please check.");
        }
    }

    private static void displayCarList(LinkedList<vehicle> list1, LinkedList<vehicle> list2) {
        System.out.println("What do you want to see?");
        System.out.println("1. Main garage\n2. Waiting list");
        Scanner in = new Scanner(System.in);
        int displayNum = in.nextInt();

        try {
            switch (displayNum) {
                case 1:
                    System.out.println("Car numbers in the Car park now:");
                    for (vehicle v : list1) {
                        System.out.println("in Park " + v.no);
                    }
                    break;

                case 2:
                    System.out.println("Cars in the waiting list: " + list2);
                    System.out.print("Enter your car number: ");
                    int removeWaitCar = in.nextInt();
                    // Implement logic to display the waiting list
                    break;

                default:
                    System.out.println("Invalid option. Please enter a valid option.");
            }
        } catch (Exception e) {
            System.out.println("You have entered a wrong option number. Please check again.");
        }
    }
}

class vehicle {
    int no;
    int mvs;

    public vehicle(int abc) {
        no = abc;
        mvs = 0;
    }

    public int incmoves(int x) {
        return (mvs + x);
    }
}
