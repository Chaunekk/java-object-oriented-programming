package fa.training.services;

import fa.training.entities.Helicopter;

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
}
