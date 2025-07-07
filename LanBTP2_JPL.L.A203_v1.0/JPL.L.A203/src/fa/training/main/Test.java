package fa.training.main;

import fa.training.services.CustomerService;

import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerService service = new CustomerService();
        int choice;

        // Menu loop
        do {
            System.out.println("Choose function:");
            System.out.println("1. Add a new Customer");
            System.out.println("2. Show all Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Remove Customer");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    List<String> customerList = service.createCustomer();
                    System.out.println(service.save(customerList));
                    break;
                case 2:
                    service.display(service.findAll());
                    break;
                case 3:
                    System.out.print("Enter phone number to search: ");
                    String phone = scanner.nextLine();
                    service.display(service.search(phone));
                    break;
                case 4:
                    System.out.print("Enter phone number to remove: ");
                    if (service.remove(scanner.nextLine())) {
                        System.out.println("Removed successfully.");
                    } else {
                        System.out.println("Customer not found or error occurred.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}