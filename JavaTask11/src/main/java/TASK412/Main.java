package TASK412;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Sellable> stock = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createStarterProduct();
        runMenu();
        scanner.close();
    }

    private static void createStarterProduct() {
        //  (-5) to test validation
        Product product1 = new Product("Rice 5kg", -5, 12);
        product1.printAllInfo();
        stock.add(product1);
    }

    private static void runMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    --- SHOP MENU ---
                    1- Add product
                    2- Add service
                    3- Print stock
                    4- Total value
                    5- Exit
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> stock.add(addProduct());
                case 2 -> stock.add(addService());
                case 3 -> {
                    int i = 1;
                    for (Sellable item : stock) {
                        System.out.print(i + ". ");
                        item.printAllInfo();
                        i++;
                    }
                }
                case 4 -> {
                    double total = 0;
                    for (Sellable item : stock) {
                        total += item.getPrice();
                    }
                    System.out.println("Total value of stock: " + total + " OMR");
                }
                case 5 -> {
                    exit = true;
                    System.out.println("Goodbye.");
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static Product addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter quantity: ");
        int qty = scanner.nextInt();
        scanner.nextLine();
        return new Product(name, price, qty);
    }

    private static Service addService() {
        System.out.print("Enter service name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter minutes: ");
        int minutes = scanner.nextInt();
        scanner.nextLine();
        return new Service(name, price, minutes);
    }
}

