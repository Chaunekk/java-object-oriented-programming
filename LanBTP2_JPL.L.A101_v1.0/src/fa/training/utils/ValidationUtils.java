package fa.training.utils;

public class ValidationUtils {
    public static boolean isValidIsbn(String isbn) {
        // Kiểm tra ISBN: 10-17 ký tự số và dấu '-'
        return isbn != null && isbn.matches("[0-9\\-]{10,17}");
    }
}
