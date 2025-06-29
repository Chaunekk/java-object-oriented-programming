package fa.training.services;

import fa.training.entities.Book;
import java.util.*;
import java.util.stream.Collectors;

public class BookService {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    // Tìm kiếm sách theo ISBN, kết quả sắp xếp theo isbn và publicationDate
    public List<Book> searchByIsbn(String isbn) {
        return books.stream()
                .filter(b -> b.getIsbn().equalsIgnoreCase(isbn))
                .sorted(Comparator.comparing(Book::getIsbn).thenComparing(Book::getPublicationDate))
                .collect(Collectors.toList());
    }

    // Tìm kiếm sách theo author, kết quả sắp xếp theo isbn và publicationDate
    public List<Book> searchByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor().stream().anyMatch(a -> a.equalsIgnoreCase(author)))
                .sorted(Comparator.comparing(Book::getIsbn).thenComparing(Book::getPublicationDate))
                .collect(Collectors.toList());
    }

    // Tìm kiếm sách theo publisher, kết quả sắp xếp theo isbn và publicationDate
    public List<Book> searchByPublisher(String publisher) {
        return books.stream()
                .filter(b -> b.getPublisher().equalsIgnoreCase(publisher))
                .sorted(Comparator.comparing(Book::getIsbn).thenComparing(Book::getPublicationDate))
                .collect(Collectors.toList());
    }

    // Thêm author cho book theo isbn, trả về thông báo
    public String addAuthorToBook(String isbn, String author) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                if (book.getAuthor().contains(author)) {
                    return "Author existed";
                } else {
                    book.getAuthor().add(author);
                    return "Add successfully";
                }
            }
        }
        return "Book not found";
    }

    // Lấy danh sách sách theo publicationYear và publisher
    public List<Book> getBooksByYearAndPublisher(int year, String publisher) {
        return books.stream()
                .filter(b -> b.getPublicationYear() == year && b.getPublisher().equalsIgnoreCase(publisher))
                .collect(Collectors.toList());
    }
}
