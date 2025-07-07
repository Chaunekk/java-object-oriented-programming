package fa.training.utils;

public class ValidationUtils {
    public static boolean isValidId(String id, String prefix) {
        return id != null && id.matches(prefix + "\\d{5}");
    }

    public static boolean isValidModel(String model) {
        return model != null && model.length() <= 40;
    }

    public static boolean isValidFixedwingType(String type) {
        return "CAG".equals(type) || "LGR".equals(type) || "PRV".equals(type);
    }

    public static boolean isValidHelicopterWeight(double emptyWeight, double maxTakeoffWeight) {
        return maxTakeoffWeight <= 1.5 * emptyWeight;
    }

    public static boolean isValidRunwaySize(double minNeededRunwaySize, double airportRunwaySize) {
        return minNeededRunwaySize <= airportRunwaySize;
    }
}
