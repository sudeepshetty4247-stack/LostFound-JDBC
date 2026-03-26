package jdbcproject;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ItemDAO dao = new ItemDAO();

        int choice;

        do {

            System.out.println("\n----- LOST & FOUND MENU -----");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
            System.out.println("3. Update Item Status");
            System.out.println("4. Delete Item");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1) {

                System.out.print("Enter Item Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Description: ");
                String desc = sc.nextLine();

                System.out.print("Enter Location Found: ");
                String loc = sc.nextLine();

                System.out.print("Enter Status: ");
                String status = sc.nextLine();

                Item item = new Item(name, desc, loc, status);
                dao.addItem(item);
            }

            else if(choice == 2) {
                dao.viewItems();
            }

            else if(choice == 3) {

                System.out.print("Enter Item ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Status: ");
                String status = sc.nextLine();

                dao.updateStatus(id, status);
            }

            else if(choice == 4) {

                System.out.print("Enter Item ID to delete: ");
                int id = sc.nextInt();
                sc.nextLine();

                dao.deleteItem(id);
            }

        } while(choice != 5);

        System.out.println("Program closed.");
        sc.close();
    }
}