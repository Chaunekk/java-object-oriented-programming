package fa.training.services;

import fa.training.entities.Customer;
import fa.training.entities.Order;
import fa.training.utils.Constants;
import fa.training.utils.Validators;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class CustomerService {
    private List<Customer> customers = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Method to create customers with their orders
    public List<String> createCustomer() {
        while (true) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            String phone;
            do {
                System.out.print("Enter phone (10 digits): ");
                phone = scanner.nextLine();
            } while (!Validators.isValidPhone(phone)); // Validate phone format

            System.out.print("Enter address: ");
            String address = scanner.nextLine();

            List<Order> orders = new ArrayList<>();
            while (true) {
                // Entering order number with validation
                System.out.print("Enter order number (10 digits): ");
                String number = scanner.nextLine();
                if (!Validators.isValidOrderNumber(number)) continue;

                // Entering and parsing date
                System.out.print("Enter date (dd/MM/yyyy): ");
                Date date = null;
                try {
                    date = sdf.parse(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid date format.");
                    continue;
                }
                orders.add(new Order(number, date));

                System.out.print("Add another order? (y/n): ");
                String more = scanner.nextLine();
                if (more.equalsIgnoreCase("n")) break;
            }

            // Add customer to list
            customers.add(new Customer(name, phone, address, orders));

            System.out.print("Add another customer? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("n")) break;
        }

        // Return customer data as string list
        List<String> result = new ArrayList<>();
        for (Customer c : customers) result.add(c.toString());
        return result;
    }

    // Save customer list to file
    public String save(List<String> customerStrList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Constants.FILE_PATH))) {
            oos.writeObject(customers);
            return "Customer data saved successfully.";
        } catch (IOException e) {
            return "Error saving customer data.";
        }
    }

    // Load and return all customers from file
    public List<String> findAll() {
        List<String> result = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constants.FILE_PATH))) {
            customers = (List<Customer>) ois.readObject();
            for (Customer c : customers) result.add(c.toString());
        } catch (Exception e) {
            result.add("No customer data found.");
        }
        return result;
    }

    // Display formatted list of customers
    public void display(List<String> list) {
        System.out.println("------LIST OF Customer------");
        list.forEach(System.out::println);
    }

    // Search customers by phone number
    public List<String> search(String phone) {
        List<String> result = new ArrayList<>();
        for (Customer c : customers) {
            if (c.getPhone().equals(phone)) result.add(c.toString());
        }
        return result;
    }

    // Remove customer by phone number and save file
    public boolean remove(String phone) {
        boolean removed = customers.removeIf(c -> c.getPhone().equals(phone));
        if (removed) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Constants.FILE_PATH))) {
                oos.writeObject(customers);
            } catch (IOException e) {
                return false;
            }
        }
        return removed;
    }
}
