package TASK415;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GymDeskMain {
    static List<Payable> members = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createNewMember();
        runMenu();
        scanner.close();
    }

    private static void createNewMember() {
        MonthlyMember newMonthlyMember = new MonthlyMember(101);
        newMonthlyMember.setName("Alice");
        newMonthlyMember.setAge(12); // invalid must return "Too young to register"
        newMonthlyMember.setMonthlyFee(300);
        newMonthlyMember.printAllInfo();
        members.add(newMonthlyMember);
    }

    private static void runMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    --- GYM MENU ---
                    1- Add monthly member
                    2- Add day-pass visitor
                    3- Print all members
                    4- Show total monthly income
                    5- Search member by name
                    6- Exit
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    members.add(addMonthly());
                    System.out.println("Added.");
                }
                case 2 -> {
                    members.add(addDayPass());
                    System.out.println("Added.");
                }
                case 3 -> {
                    int i = 1;
                    for (Payable p : members) {
                        System.out.print(i + ". ");
                        p.printAllInfo();
                        i++;
                    }
                }
                case 4 -> {
                    double total = 0;
                    for (Payable p : members) {
                        total += p.monthlyTotal();
                    }
                    System.out.println("Total monthly income: " + total + " OMR");
                }
                case 5 -> {
                    System.out.print("Enter name to search: ");
                    String search = scanner.nextLine();
                    boolean found = false;
                    for (Payable p : members) {
                        if (p.getName() != null && p.getName().equals(search)) {
                            p.printAllInfo();
                            found = true;
                        }
                    }
                    if (!found) System.out.println("No member found.");
                }
                case 6 -> {
                    exit = true;
                    System.out.println("Goodbye.");
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static MonthlyMember addMonthly() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        MonthlyMember m = new MonthlyMember(id);
        System.out.print("Enter name: ");
        m.setName(scanner.nextLine());
        System.out.print("Enter age: ");
        m.setAge(scanner.nextInt());
        System.out.print("Enter monthly fee: ");
        m.setMonthlyFee(scanner.nextDouble());
        scanner.nextLine();
        return m;
    }

    private static DayPassVisitor addDayPass() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        DayPassVisitor visitor = new DayPassVisitor(id);
        System.out.print("Enter name: ");
        visitor.setName(scanner.nextLine());
        System.out.print("Enter age: ");
        visitor.setAge(scanner.nextInt());
        System.out.print("Enter price per visit: ");
        visitor.setPricePerVisit(scanner.nextDouble());
        System.out.print("Enter number of visits: ");
        visitor.setVisits(scanner.nextInt());
        scanner.nextLine();
        return visitor;
    }
}