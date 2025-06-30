package fa.training.services;

import fa.training.entities.Fixedwing;

/**
 * Service cho các nghiệp vụ liên quan đến máy bay cánh cố định (Fixedwing)
 */
public class FixedwingService {
    /**
     * Đổi loại máy bay cánh cố định
     */
    public void changePlaneType(Fixedwing fixedwing, String newType) {
        fixedwing.setPlaneType(newType);
    }

    /**
     * Đổi runway size tối thiểu cần thiết của máy bay cánh cố định
     */
    public void changeMinNeededRunwaySize(Fixedwing fixedwing, double newSize) {
        fixedwing.setMinNeededRunwaySize(newSize);
    }
}
