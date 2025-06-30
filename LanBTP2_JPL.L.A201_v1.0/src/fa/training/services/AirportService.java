package fa.training.services;

import fa.training.entities.Airport;
import fa.training.entities.Fixedwing;
import fa.training.entities.Helicopter;
import java.util.List;

public class AirportService {
//    Thêm máy bay cánh cố định vào sân bay nếu còn chỗ và runway đủ dài
    public void addFixedwingToAirport(Airport airport, Fixedwing fixedwing) {
        if (airport.getFixedwingIDs().size() < airport.getMaxFixedwingParkingPlace()
                && fixedwing.getMinNeededRunwaySize() <= airport.getRunwaySize()) {
            airport.getFixedwingIDs().add(fixedwing.getId());
        } else {
            throw new IllegalArgumentException("Không thể thêm fixedwing vào sân bay này!");
        }
    }
    // Thêm trực thăng vào sân bay nếu còn chỗ
    public void addHelicopterToAirport(Airport airport, Helicopter helicopter) {
        if (airport.getHelicopterIDs().size() < airport.getMaxRotatedwingParkingPlace()) {
            airport.getHelicopterIDs().add(helicopter.getId());
        } else {
            throw new IllegalArgumentException("Không thể thêm helicopter vào sân bay này!");
        }
    }

    // Xóa trực thăng khỏi sân bay
    public void removeHelicopterFromAirport(Airport airport, String helicopterId) {
        airport.getHelicopterIDs().remove(helicopterId);
    }

    // Xóa máy bay cánh cố định khỏi sân bay
    public void removeFixedwingFromAirport(Airport airport, String fixedwingId) {
        airport.getFixedwingIDs().remove(fixedwingId);
    }

    // Tìm sân bay theo ID
    public Airport findAirportById(List<Airport> airports, String id) {
        return airports.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }
}
