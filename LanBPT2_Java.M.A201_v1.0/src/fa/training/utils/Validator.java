package fa.training.utils;

public class Validator {
    public static boolean isValidCourseCode(String code) {
        return code != null && code.matches("FW\\d{3}");
    }

    public static boolean isValidStatus(String status) {
        return "active".equalsIgnoreCase(status) || "in-active".equalsIgnoreCase(status);
    }

    public static boolean isValidFlag(String flag) {
        return "optional".equalsIgnoreCase(flag) || "mandatory".equalsIgnoreCase(flag) || "N/A".equalsIgnoreCase(flag);
    }
}
