package TASK414;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalDeskMain {
    static List<Rentable> hires = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        createNewCar();
        runMenu();
        scanner.close();
    }
    private static void createNewCar() {
        Car car1 = new Car("Red"); // immutable color set once
        car1.setPlate("A123");
        car1.setSeats(5);
        car1.setDailyRate(50);
        car1.setRentalDays(7);
        car1.printAllInfo();
        hires.add(car1);
    }

    private static void runMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    --- RENTAL MENU ---
                    1- Add car
                    2- Add motorbike
                    3- Print all hires
                    4- Show total income
                    5- Exit
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    hires.add(addCar());
                    System.out.println("Added.");
                }
                case 2 -> {
                    hires.add(addMotorbike());
                    System.out.println("Added.");
                }
                case 3 -> {
                    int i = 1;
                    for (Rentable rent : hires) {
                        System.out.print(i + ". ");
                        rent.printAllInfo();
                        i++;
                    }
                }
                case 4 -> {
                    double total = 0;
                    for (Rentable r : hires) {
                        total += r.costFor(r.getRentalDays());
                    }
                    System.out.println("Total income: " + total + " OMR");
                }
                case 5 -> {
                    exit = true;
                    System.out.println("Goodbye.");
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static Car addCar() {
        Car newCar = new Car("Blue");
        System.out.print("Enter plate: ");
        newCar.setPlate(scanner.nextLine());
        System.out.print("Enter seats: ");
        newCar.setSeats(scanner.nextInt());
        System.out.print("Enter daily rate: ");
        newCar.setDailyRate(scanner.nextInt());
        System.out.print("Enter rental days: ");
        newCar.setRentalDays(scanner.nextInt());
        scanner.nextLine();
        return newCar;
    }

    private static Motorbike addMotorbike() {
        Motorbike newMotorbike = new Motorbike("Black");
        System.out.print("Enter plate: ");
        newMotorbike.setPlate(scanner.nextLine());
        System.out.print("Enter engine size: ");
        newMotorbike.setEngineSize(scanner.nextInt());
        System.out.print("Enter daily rate: ");
        newMotorbike.setDailyRate(scanner.nextInt());
        System.out.print("Enter rental days: ");
        newMotorbike.setRentalDays(scanner.nextInt());
        scanner.nextLine();
        return newMotorbike;
    }
}