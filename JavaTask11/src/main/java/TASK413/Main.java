package TASK413;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static List<Attendable> queue = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createStarterPatient(); 
        runMenu();
        scanner.close();
    }

    private static void createStarterPatient() {

        BookedPatient patient1 = new BookedPatient(930);
        patient1.setName("Sarah Bennett");
        patient1.setAge(150); // invalid
        patient1.printAllInfo();
        queue.add(patient1);
    }

    private static void runMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    --- CLINIC MENU ---
                    1- Add booked
                    2- Add walk-in
                    3- Print queue
                    4- Longest wait
                    5- Exit
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    queue.add(addBooked());
                    System.out.println("Added.");
                }
                case 2 -> {
                    queue.add(addWalkIn());
                    System.out.println("Added.");
                }
                case 3 -> {
                    int i = 1;
                    for (Attendable a : queue) {
                        System.out.print(i + ". ");
                        a.printAllInfo();
                        i++;
                    }
                }
                case 4 -> {
                    int maxWait = 0;
                    String longestName = "";
                    for (Attendable a : queue) {
                        if (a.getWaitMinutes() > maxWait) {
                            maxWait = a.getWaitMinutes();
                            if (a instanceof BookedPatient bp) {
                                longestName = bp.getName();
                            } else if (a instanceof WalkInVisitor wv) {
                                longestName = wv.getName();
                            }
                        }
                    }
                    System.out.println("Longest wait: " + longestName + " (" + maxWait + " min)");
                }
                case 5 -> {
                    exit = true;
                    System.out.println("Goodbye.");
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static BookedPatient addBooked() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter slot time (e.g. 930 for 09:30): ");
        int slot = scanner.nextInt();
        scanner.nextLine();

        BookedPatient booked = new BookedPatient(slot);
        booked.setName(name);
        booked.setAge(age);
        return booked;
    }

    private static WalkInVisitor addWalkIn() {
        WalkInVisitor walk = new WalkInVisitor();
        System.out.print("Enter name: ");
        walk.setName(scanner.nextLine());
        System.out.print("Enter age: ");
        walk.setAge(scanner.nextInt());
        System.out.print("Enter arrival order: ");
        walk.setArrivalOrder(scanner.nextInt());
        scanner.nextLine();
        return walk;
    }
}
