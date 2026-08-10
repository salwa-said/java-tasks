package TASK411;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryMain {
    static List<LibraryItem> catalogue = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createStarterBook();
        runMenu();
        scanner.close();
    }

    private static void createStarterBook() {
        Book book = new Book();
        book.setTitle("Clean Code");
        book.setAuthor("Robert Martin");
        book.setPages(464);
        book.printAllInfo();
        catalogue.add(book);
    }

    private static void runMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    --- LIBRARY MENU ---
                    1- Add book
                    2- Add magazine
                    3- Print all
                    4- Count items
                    5- Exit
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    catalogue.add(addBook());
                    System.out.println("Added.");
                }
                case 2 -> {
                    catalogue.add(addMagazine());
                    System.out.println("Added.");
                }
                case 3 -> {
                    int i = 1;
                    for (LibraryItem item : catalogue) {
                        System.out.print(i + ". ");
                        item.printAllInfo();
                        i++;
                    }
                }
                case 4 -> System.out.println("Total items: " + catalogue.size());
                case 5 -> {
                    exit = true;
                    System.out.println("Goodbye.");
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static Book addBook() {
        Book book1 = new Book();
        System.out.print("Enter title: ");
        book1.setTitle(scanner.nextLine());
        System.out.print("Enter author: ");
        book1.setAuthor(scanner.nextLine());
        System.out.print("Enter pages: ");
        book1.setPages(scanner.nextInt());
        scanner.nextLine();
        return book1;
    }

    private static Magazine addMagazine() {
        Magazine magazine1 = new Magazine();
        System.out.print("Enter name: ");
        magazine1.setName(scanner.nextLine());
        System.out.print("Enter issue number: ");
        magazine1.setIssueNumber(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter month: ");
        magazine1.setMonth(scanner.nextLine());
        return magazine1;
    }
}