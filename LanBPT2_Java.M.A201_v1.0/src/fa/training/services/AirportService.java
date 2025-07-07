package fa.training.services;

import fa.training.entities.Airport;
import fa.training.entities.Fixedwing;
import fa.training.entities.Helicopter;
import java.util.List;
import java.util.ArrayList;

/**
 * Service cho các nghiệp vụ liên quan đến sân bay
 */
public class AirportService {
    /**
     * Thêm máy bay cánh cố định vào sân bay nếu còn chỗ, runway đủ dài và không trùng ID
     */
    public void addFixedwingToAirport(Airport airport, Fixedwing fixedwing) {
        if (airport.getFixedwingIDs().contains(fixedwing.getId())) {
            throw new IllegalArgumentException("ID máy bay đã tồn tại trong sân bay!");
        }
        if (airport.getFixedwingIDs().size() < airport.getMaxFixedwingParkingPlace()
                && fixedwing.getMinNeededRunwaySize() <= airport.getRunwaySize()) {
            airport.getFixedwingIDs().add(fixedwing.getId());
        } else {
            throw new IllegalArgumentException("Không thể thêm fixedwing vào sân bay này!");
        }
    }

    /**
     * Thêm trực thăng vào sân bay nếu còn chỗ và không trùng ID
     */
    public void addHelicopterToAirport(Airport airport, Helicopter helicopter) {
        if (airport.getHelicopterIDs().contains(helicopter.getId())) {
            throw new IllegalArgumentException("ID trực thăng đã tồn tại trong sân bay!");
        }
        if (airport.getHelicopterIDs().size() < airport.getMaxRotatedwingParkingPlace()) {
            airport.getHelicopterIDs().add(helicopter.getId());
        } else {
            throw new IllegalArgumentException("Không thể thêm helicopter vào sân bay này!");
        }
    }

    /**
     * Xóa trực thăng khỏi sân bay, báo lỗi nếu không tìm thấy
     */
    public void removeHelicopterFromAirport(Airport airport, String helicopterId) {
        if (!airport.getHelicopterIDs().remove(helicopterId)) {
            throw new IllegalArgumentException("Không tìm thấy trực thăng trong sân bay!");
        }
    }

    /**
     * Xóa máy bay cánh cố định khỏi sân bay, báo lỗi nếu không tìm thấy
     */
    public void removeFixedwingFromAirport(Airport airport, String fixedwingId) {
        if (!airport.getFixedwingIDs().remove(fixedwingId)) {
            throw new IllegalArgumentException("Không tìm thấy fixedwing trong sân bay!");
        }
    }

    /**
     * Tìm sân bay theo ID
     */
    public Airport findAirportById(List<Airport> airports, String id) {
        return airports.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * Lấy danh sách Fixedwing chưa đỗ ở sân bay nào
     */
    public List<Fixedwing> getUnparkedFixedwings(List<Fixedwing> allFixedwings, List<Airport> airports) {
        List<String> parkedIds = new ArrayList<>();
        for (Airport ap : airports) {
            parkedIds.addAll(ap.getFixedwingIDs());
        }
        List<Fixedwing> result = new ArrayList<>();
        for (Fixedwing fw : allFixedwings) {
            if (!parkedIds.contains(fw.getId())) {
                result.add(fw);
            }
        }
        return result;
    }

    /**
     * Lấy danh sách Helicopter chưa đỗ ở sân bay nào
     */
    public List<Helicopter> getUnparkedHelicopters(List<Helicopter> allHelicopters, List<Airport> airports) {
        List<String> parkedIds = new ArrayList<>();
        for (Airport ap : airports) {
            parkedIds.addAll(ap.getHelicopterIDs());
        }
        List<Helicopter> result = new ArrayList<>();
        for (Helicopter h : allHelicopters) {
            if (!parkedIds.contains(h.getId())) {
                result.add(h);
            }
        }
        return result;
    }
}