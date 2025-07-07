package fa.training.services;

import fa.training.entities.Helicopter;
import fa.training.entities.Airport;
import java.util.List;

/**
 * Service cho các nghiệp vụ liên quan đến trực thăng
 */
public class HelicopterService {
    /**
     * Kiểm tra điều kiện trọng lượng của trực thăng
     * @param emptyWeight trọng lượng rỗng
     * @param maxTakeoffWeight trọng lượng cất cánh tối đa
     * @return true nếu hợp lệ, false nếu vượt quá 1.5 lần trọng lượng rỗng
     */
    public boolean canAddHelicopter(double emptyWeight, double maxTakeoffWeight) {
        return maxTakeoffWeight <= 1.5 * emptyWeight;
    }

    /**
     * Kiểm tra ID trực thăng đã tồn tại trong danh sách chưa
     * @param helicopters danh sách trực thăng
     * @param id ID cần kiểm tra
     * @return true nếu đã tồn tại, false nếu chưa
     */
    public boolean isDuplicateId(List<Helicopter> helicopters, String id) {
        for (Helicopter h : helicopters) {
            if (h.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Kiểm tra trực thăng đã đỗ ở sân bay nào chưa
     * @param airports danh sách sân bay
     * @param helicopterId ID trực thăng
     * @return true nếu đã đỗ ở sân bay, false nếu chưa
     */
    public boolean isParkedInAnyAirport(List<Airport> airports, String helicopterId) {
        for (Airport airport : airports) {
            if (airport.getHelicopterIDs().contains(helicopterId)) {
                return true;
            }
        }
        return false;
    }
}