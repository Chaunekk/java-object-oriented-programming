package fa.training.main;

import fa.training.entities.Book;
import fa.training.entities.Magazine;
import fa.training.services.BookService;
import fa.training.services.MagazineService;
import fa.training.utils.ValidationUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LibraryManagement {
    private static int readInt(Scanner scanner, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        return value;
    }

    private static Date readDate(Scanner scanner, String prompt, SimpleDateFormat sdf) {
        Date date = null;
        while (true) {
            System.out.print(prompt);
            String dateStr = scanner.nextLine();
            try {
                date = sdf.parse(dateStr);
                break;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }
        return date;
    }

    private static String readValidIsbn(Scanner scanner, String prompt) {
        String isbn;
        while (true) {
            System.out.print(prompt);
            isbn = scanner.nextLine();
            if (ValidationUtils.isValidIsbn(isbn)) {
                break;
            } else {
                System.out.println("Invalid ISBN format. Please try again.");
            }
        }
        return isbn;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookService bookService = new BookService();
        MagazineService magazineService = new MagazineService();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int choice;
        do {
            System.out.println("====== LIBRARY MANAGEMENT SYSTEM ======");
            System.out.println("1. Add a book");
            System.out.println("2. Add a magazine");
            System.out.println("3. Display books and magazines");
            System.out.println("4. Add author to book");
            System.out.println("5. Display top 10 of magazines by volume");
            System.out.println("6. Search book by (isbn, author, publisher)");
            System.out.println("0. Exit");
            choice = readInt(scanner, "Please choose function you'd like to do: ");
            switch (choice) {
                case 1:
                    // Add a book
                    int year = readInt(scanner, "Enter publication year: ");
                    System.out.print("Enter publisher: ");
                    String publisher = scanner.nextLine();
                    Date date = readDate(scanner, "Enter publication date (yyyy-MM-dd): ", sdf);
                    String isbn = readValidIsbn(scanner, "Enter ISBN: ");
                    System.out.print("Enter publication place: ");
                    String place = scanner.nextLine();
                    int n = readInt(scanner, "Enter number of authors: ");
                    while (n <= 0) {
                        System.out.println("Number must be greater than 0.");
                        n = readInt(scanner, "Enter number of authors: ");
                    }
                    Set<String> authors = new HashSet<>();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter author " + (i+1) + ": ");
                        authors.add(scanner.nextLine());
                    }
                    Book book = new Book(year, publisher, date, isbn, authors, place);
                    bookService.addBook(book);
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    // Add a magazine
                    int mYear = readInt(scanner, "Enter publication year: ");
                    System.out.print("Enter publisher: ");
                    String mPublisher = scanner.nextLine();
                    Date mDate = readDate(scanner, "Enter publication date (yyyy-MM-dd): ", sdf);
                    System.out.print("Enter author: ");
                    String mAuthor = scanner.nextLine();
                    int volume = readInt(scanner, "Enter volume: ");
                    int edition = readInt(scanner, "Enter edition: ");
                    Magazine magazine = new Magazine(mYear, mPublisher, mDate, mAuthor, volume, edition);
                    magazineService.addMagazine(magazine);
                    System.out.println("Magazine added successfully!");
                    break;
                case 3:
                    // Display all books and magazines
                    List<Book> books = bookService.getBooks();
                    List<Magazine> magazines = magazineService.getMagazines();
                    System.out.println("--- Books ---");
                    books.forEach(Book::display);
                    System.out.println("--- Magazines ---");
                    magazines.forEach(Magazine::display);
                    break;
                case 4:
                    // Add author to book
                    System.out.print("Enter ISBN of the book: ");
                    String aIsbn = scanner.nextLine();
                    System.out.print("Enter author to add: ");
                    String aAuthor = scanner.nextLine();
                    String result = bookService.addAuthorToBook(aIsbn, aAuthor);
                    System.out.println(result);
                    break;
                case 5:
                    // Display top 10 magazines by volume
                    List<Magazine> topMagazines = magazineService.getTop10ByVolume();
                    System.out.println("--- Top 10 Magazines by Volume ---");
                    topMagazines.forEach(Magazine::display);
                    break;
                case 6:
                    // Search book by (isbn, author, publisher)
                    int searchType;
                    while (true) {
                        System.out.println("Search by: 1. ISBN  2. Author  3. Publisher");
                        searchType = readInt(scanner, "Your choice: ");
                        if (searchType >= 1 && searchType <= 3) break;
                        else System.out.println("Invalid search type. Please choose 1, 2, or 3.");
                    }
                    List<Book> searchResult = new ArrayList<>();
                    switch (searchType) {
                        case 1:
                            System.out.print("Enter ISBN: ");
                            String sIsbn = scanner.nextLine();
                            searchResult = bookService.searchByIsbn(sIsbn);
                            break;
                        case 2:
                            System.out.print("Enter author: ");
                            String sAuthor = scanner.nextLine();
                            searchResult = bookService.searchByAuthor(sAuthor);
                            break;
                        case 3:
                            System.out.print("Enter publisher: ");
                            String sPublisher = scanner.nextLine();
                            searchResult = bookService.searchByPublisher(sPublisher);
                            break;
                    }
                    System.out.println("--- Search Result ---");
                    searchResult.forEach(Book::display);
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 0);
        scanner.close();
    }
}
